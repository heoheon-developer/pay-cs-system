package com.pay.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("Data Rest TEST")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired  MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void inquiries_test() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/inquiries")).andExpect(status().isOk());
    }
}
