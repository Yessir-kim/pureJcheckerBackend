package edu.isel.csee.TesterForDB.controller.api;

import edu.isel.csee.jchecker.core.CoreGrader;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController // @ResponseBody 포함
@RequestMapping(value="/api") // base url
public class ExecuteController {

    @RequestMapping(value="/execute", method= RequestMethod.POST, produces={"application/json"})
    public ResponseEntity<String> executeApi(@RequestParam(required = false, value = "studentNum") String studentNum,
                                             @RequestParam(required = false, value = "assignment") String assignment,
                                             @RequestParam("file") MultipartFile multipartFile) {

        System.out.println(System.getProperty("user.dir"));

        File target = new File("assignments/" + multipartFile.getOriginalFilename());

        try {
            InputStream stream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(stream, target);

            CoreGrader grader = new CoreGrader();
            //grader.start("","");

        } catch (IOException e) {
            FileUtils.deleteQuietly(target);
            e.printStackTrace();
        }

        // 1. studentNum을 바탕으로 DB에 접근해서 해당 학생의 소스를 가져와야 함 --> 파일을 받는 것으로 수정
        // 2. assignment를 바탕으로 DB에 접근해서 해당 과제의 policy를 가져와야 함
        // 3. 해당 정보를 바탕으로 채점이 진행되고 완료되면 JSON 형식의 String type 결과를 얻을 수 있음

       String ExampleOfJSON =
               "{\n" +
               "    \"name\": \"HW3-Data-Parser\",\n" +
               "    \"group\": \"JC-java-class\",\n" +
               "    \"student-ID\": \"21600065\",\n" +
               "    \"grade-date\": \"2021-01-26 15:54:23\",\n" +
               "    \"point\": 14.0,\n" +
               "    \"result\": 11.4,\n" +
               "    \"runtime-result\": {\n" +
               "        \"violation-number\": [\n" +
               "            \"1\",\n" +
               "            \"5\",\n" +
               "            \"6\"\n" +
               "        ],\n" +
               "        \"violation-count\": 3,\n" +
               "        \"deducted\": 0.6\n" +
               "    },\n" +
               "    \"package\": {\n" +
               "        \"violation\": false,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"classes\": {\n" +
               "        \"violation-count\": 0,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"inherit-super\": {\n" +
               "        \"violation-count\": 0,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"inherit-interface\": {\n" +
               "        \"violation-count\": 0,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"overriding\": {\n" +
               "        \"violation\": false,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"javadoc\": {\n" +
               "        \"violation\": false,\n" +
               "        \"deducted\": 0\n" +
               "    },\n" +
               "    \"encapsulation\": {\n" +
               "        \"violation\": true,\n" +
               "        \"deducted\": 2.0\n" +
               "    }\n" +
               "}" ;

       // status + result 동시에 return
       return ResponseEntity.ok(ExampleOfJSON) ;
    }
}
