package edu.isel.csee.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<Map<String, Object>> handler(RestException e) {
        Map<String, Object> resBody = new HashMap<>();
        Map<String, Object> resSub = new HashMap<>();
        resSub.put("msg", e.getMessage());
        resBody.put("data", resSub);
        resBody.put("status", e.getStatus().value());

        return new ResponseEntity(resBody, e.getStatus());
    }

}
