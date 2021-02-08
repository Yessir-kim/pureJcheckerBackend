package edu.isel.csee.TesterForDB.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/user") // base url
public class UserController {

    @RequestMapping(value="", method= RequestMethod.GET, produces={"application/json"})
    public ResponseEntity<String> getUserInfo(@RequestParam("studentNum") String studentNum) {

        // DB에서 학번을 바탕으로 정보를 조회해서 JSON 형태로 반환해야 함
        String ExampleOfJSON =
                "{\n" +
                "  \"userName\": \"kim\",\n" +
                "  \"studentNum\": \"21600108\",\n" +
                "  \"email\": \"21600108@handong.edu\",\n" +
                "  \"course\": \"Java\",\n" +
                "  \"section\": \"1\"\n" +
                "}" ;

        return ResponseEntity.ok(ExampleOfJSON) ;
    }
}
