package com.pay.controller;

import com.pay.domain.Inquiry;
import com.pay.repository.InquiryRepository;
import com.pay.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
@RequestMapping("/api/inquiry")
public class InquiryController {


    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InquiryService inquiryService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInquiryList(){
        try{
            Iterable<Inquiry> inquiries = inquiryService.getInquiryList();

            logger.info("inquiries", inquiries.iterator());
            return new ResponseEntity<Object>(inquiries, HttpStatus.OK);
        } catch(Exception ex){
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }





    }

}
