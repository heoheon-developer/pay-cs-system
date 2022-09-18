package com.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BaseController {

    @GetMapping("/main")
    public String index(){
        return "index.html";
    }

}
