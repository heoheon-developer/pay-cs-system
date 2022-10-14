package com.pay.controller;

import com.pay.service.CounselorService;
import com.pay.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    private final JwtUtil jwtUtil;

    private final CounselorService counselorService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtUtil jwtUtil, CounselorService counselorService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.counselorService = counselorService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
        String id = paramMap.get("user_id");
        String pw = paramMap.get("user_pw");
        log.debug("id->>>>", id);
        log.debug("pw->>>>", pw);

        UserDetails loginUser = counselorService.loadUserByUsername(id);
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser, loginUser));
//
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());

        Map<String, Object> result = new HashMap<>();
        result.put("user_id", loginUser.getUsername());
        result.put("access_token", accessToken);
        result.put("user_role", loginUser.getAuthorities().stream().findFirst().get().getAuthority());
        return ResponseEntity.ok(result);
    }



}
