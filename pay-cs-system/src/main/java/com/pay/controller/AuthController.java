package com.pay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
@Slf4j
public class AuthController {


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
        String id = paramMap.get("user_id");
        String pw = paramMap.get("user_pwd");
        log.debug("id->>>>", id);
        log.debug("pw->>>>", pw);
        Map<String, Object> result = new HashMap<>();
        return ResponseEntity.ok(result);
    }



}
