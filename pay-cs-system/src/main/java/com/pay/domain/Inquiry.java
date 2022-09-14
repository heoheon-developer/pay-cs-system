package com.pay.domain;

import com.pay.enums.InquiryStatus;

import java.time.LocalDateTime;

public class Inquiry {

    private Integer id;
    private Customer customer; // 고객
    private String title; // 제목
    private String contents; // 문의 내용
    private InquiryStatus status; // 문의 상태
    private LocalDateTime createAt; // 생성일
    private LocalDateTime updateAt; // 수정일
    private LocalDateTime deleteAt; // 삭제일

}
