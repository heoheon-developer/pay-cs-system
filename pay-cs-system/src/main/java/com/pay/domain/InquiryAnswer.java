package com.pay.domain;

import com.pay.enums.InquiryStatus;

import java.time.LocalDateTime;

public class InquiryAnswer {

    private Integer id;
    private Inquiry inquiry; // 해당문의
    private Counselor counselor; // 상담사
    private String contents; // 답변 내용
    private LocalDateTime createAt; // 생성일
    private LocalDateTime updateAt; // 수정일
    private LocalDateTime deleteAt; // 삭제일
    
}
