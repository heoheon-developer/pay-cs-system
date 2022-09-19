package com.pay.controller;

import com.pay.domain.Inquiry;
import com.pay.dto.InquiryDto;
import com.pay.dto.request.InquiryCreateDto;
import com.pay.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/inquiry")
@CrossOrigin
public class InquiryController {
        @Autowired
        private InquiryService inquiryService;

        @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<List<InquiryDto>> inquiries(Model model) {
                List<InquiryDto> inquiryList = this.inquiryService.findAll();
                log.info("inquiryList == " + inquiryList);
                return new ResponseEntity<List<InquiryDto>>(inquiryList, HttpStatus.OK);
        }

        @PostMapping("/create")
        public Inquiry create(@RequestBody InquiryCreateDto inquiryCreateDto){
                log.debug("create=>>>", inquiryCreateDto);
                return inquiryService.create(inquiryCreateDto);
        };


}
