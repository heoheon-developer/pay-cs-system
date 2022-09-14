package com.pay.domain;

import com.pay.enums.InquiryStatus;

import java.time.LocalDateTime;

public class Customer {

    private Integer id;
    private String customerId; // 고객 ID
    private String customerName; // 고객 이름
    private String customerPhone; // 고객 전화
    private LocalDateTime createAt; // 생성일
    private LocalDateTime updateAt; // 수정일
    private LocalDateTime deleteAt; // 삭제일

}
