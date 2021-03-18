package edu.isel.csee.backend.controller.api;

import com.google.gson.Gson;
import edu.isel.csee.backend.form.document.Token;
import edu.isel.csee.backend.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping(value="/api/token")
public class TokenController {

    private TokenService tokenService;

    @RequestMapping(value="/find", method= RequestMethod.POST, produces={"application/json"})
    public ResponseEntity<String> find(@RequestBody String token) {

        Token result = tokenService.getToken(token);

        return ResponseEntity.ok(new Gson().toJson(result));
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<?> list() {

        return ResponseEntity.ok(tokenService.getTokenList());
    }

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
}
