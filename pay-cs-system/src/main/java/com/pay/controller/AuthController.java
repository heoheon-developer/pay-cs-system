package com.pay.controller;


import com.pay.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
@Slf4j
public class AuthController {
    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
        String id = paramMap.get("user_id");
        String pw = paramMap.get("user_pwd");
        log.debug("id->>>>", id);
        log.debug("pw->>>>", pw);
        Map<String, Object> result = new HashMap<>();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/authInfo")
    public Authentication auth(){
        return SecurityContextHolder.getContext().getAuthentication();
    }




}
