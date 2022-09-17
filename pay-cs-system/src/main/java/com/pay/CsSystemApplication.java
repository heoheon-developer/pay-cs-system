package com.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class CsSystemApplication {

    public static void main(String[] args){
        SpringApplication.run(CsSystemApplication.class, args);
    }

}
