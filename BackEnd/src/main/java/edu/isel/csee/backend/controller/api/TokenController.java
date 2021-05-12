package edu.isel.csee.backend.controller.api;

import com.google.gson.Gson;
import edu.isel.csee.backend.controller.RestException;
import edu.isel.csee.backend.form.document.Token;
import edu.isel.csee.backend.service.TokenService;
import edu.isel.csee.jchecker.submit.Extractor;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(value="/api/token")
public class TokenController {

    private TokenService tokenService;

    @RequestMapping(value="/find", method= RequestMethod.GET, produces={"application/json"})
    public ResponseEntity<String> find(@RequestParam String token) {

        Token result = tokenService.getToken(token);

        return ResponseEntity.ok(new Gson().toJson(result));
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> list() {

        return ResponseEntity.ok(tokenService.getTokenList());
    }

    /*
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ResponseEntity<?> save(@RequestPart(value="token") Token token, @RequestPart(value="file") MultipartFile[] files) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate = format.format(new Date());
        token.setCreateDate(nowDate);

        File target = null;
        // "/data/jchecker...."
        String filePath = "assignments/jchecker/inputData/" + token.getClassName() ;

        if(files.length > 0) token.setFilePath(filePath);

        try
        {
            for (MultipartFile file : files)
            {
                String zipPath = "assignments/jchecker/inputData/" + token.getClassName() + "/"+ file.getOriginalFilename();
                target = new File(zipPath);

                System.out.println("storage path : /data/jchecker/inputData/" + token.getClassName()) ;
                System.out.println("File name : " + file.getOriginalFilename()) ;

                InputStream stream = file.getInputStream();
                FileUtils.copyInputStreamToFile(stream, target);

                new Extractor().unzip(zipPath, filePath);

                deleteTrashFile(filePath + "/") ;
                deleteZipFile(zipPath) ;
            }
        }
        catch (Exception e) { System.out.println(e.getMessage()); throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Grading failed!"); }


        return ResponseEntity.ok(tokenService.saveToken(token));
    }
    */

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Token token) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate = format.format(new Date());
        token.setCreateDate(nowDate);

        return ResponseEntity.ok(tokenService.saveToken(token));
    }

    @RequestMapping(value="/delete/{token}", method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("token") String token) {
        return ResponseEntity.ok(tokenService.deleteToken(token));
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

    public void deleteZipFile(String crtPath)
    {
        File zipFile = new File(crtPath);

        zipFile.delete();
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
