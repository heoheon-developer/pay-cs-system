package com.pay.controller;

import com.pay.service.InquiryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Controller Test")
@WebMvcTest(InquiryController.class)
class InquiryControllerTest {

    private final MockMvc mvc;

    InquiryControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[GET] 문의글 전체 목록 호출")
    @Test
    void given_whenRequest_thenReturnInquiries() throws Exception {

        // Given

        // When & Then
        mvc.perform(get("/inquiries/list"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("inquiries"));
    }


}