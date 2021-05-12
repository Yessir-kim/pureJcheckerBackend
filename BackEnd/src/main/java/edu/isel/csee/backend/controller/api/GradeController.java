package edu.isel.csee.backend.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.isel.csee.backend.controller.RestException;
import edu.isel.csee.backend.form.document.Grade;
import edu.isel.csee.backend.form.document.Token;
import edu.isel.csee.backend.service.GradeService;
import edu.isel.csee.backend.service.TokenService;
import edu.isel.csee.jchecker.core.CoreGrader;
import edu.isel.csee.jchecker.submit.Extractor;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping(value="/api/grade")
public class GradeController {

    private GradeService gradeService;
    private TokenService tokenService;

    @RequestMapping(value="/find", method=RequestMethod.GET, produces={"application/json"})
    public ResponseEntity<String> find(@RequestParam("studentNum") String studentNum,
                                       @RequestParam("token") String token) {

        Grade grade = gradeService.getGrade(studentNum, token);

        return ResponseEntity.ok(new Gson().toJson(grade));
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Grade grade) {

        return ResponseEntity.ok(gradeService.saveGrade(grade));
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> list(@RequestParam("itoken") String itoken) {

        return ResponseEntity.ok( gradeService.getGradeList(itoken) );
    }

    @RequestMapping(value="/delete/{name}/{studentNum}", method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("token") String token,
                                    @PathVariable("studentNum") String studentNum) {

        return ResponseEntity.ok(gradeService.deleteGrade(studentNum, token));
    }

    @RequestMapping(value="/execute", method=RequestMethod.POST, produces={"application/json"})
    public ResponseEntity<?> execute(@RequestParam(value = "studentNum") String studentNum,
                                     @RequestParam(value = "token") String token,
                                     @RequestParam("file") MultipartFile multipartFile) {

        DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_");
        String output = "assignments/" + studentNum + "/auto/";
        String result;
        Grade toSave;
        // String output = "/data/jchecker/" + studentNum + "/";

        String filePath = output + multipartFile.getOriginalFilename();
        File target = new File(filePath);

        try
        {
            InputStream stream = multipartFile.getInputStream();
            FileUtils .copyInputStreamToFile(stream, target);

            Token policy = tokenService.getToken(token);

            new Extractor().unzip(filePath, output);

            target.renameTo(new File(output + format.format(new Date()) + multipartFile.getOriginalFilename()));

            deleteTrashFile(output);

            result = new CoreGrader().start(output, new Gson().toJson(policy));

            ObjectMapper objectMapper = new ObjectMapper();

            toSave = objectMapper.readValue(result, Grade.class);

            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = format.format(new Date());

            System.out.println(nowDate);

            toSave.setGradingDate(nowDate);
            toSave.setStudentNum(studentNum);
            toSave.setItoken(policy.getItoken());
            gradeService.saveGrade(toSave);
        }
        catch (Exception e) { System.out.println(e.getMessage()); throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Grading failed!"); }
        finally
        {
            FileUtils.deleteQuietly(target);
            deleteFile(output);
        }

        return ResponseEntity.ok(new Gson().toJson(toSave));
    }

    public void deleteTrashFile(String crtPath)
    {
        File FileList = new File(crtPath);

        String fileList[] = FileList.list();

        for(int i = 0; i < fileList.length; i++)
        {
            String FileName = fileList[i];

            if (FileName.contains("__MACOSX")) deleteFile(crtPath + FileName);
        }
    }

    public void deleteFile(String path)
    {
        File deleteFolder = new File(path);

        if(deleteFolder.exists())
        {
            File[] deleteFolderList = deleteFolder.listFiles();

            for (int i = 0; i < deleteFolderList.length; i++)
            {
                if(deleteFolderList[i].isFile()) { deleteFolderList[i].delete(); }
                else { deleteFile(deleteFolderList[i].getPath()); }

                deleteFolderList[i].delete();
            }
            deleteFolder.delete();
        }
    }
}
