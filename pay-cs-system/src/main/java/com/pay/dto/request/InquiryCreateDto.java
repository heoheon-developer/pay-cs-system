package com.pay.dto.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryCreateDto {

    String customerId;
    String title;
    String contents;
}
