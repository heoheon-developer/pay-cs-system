package com.pay.dto.request;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class InquiryDto {

    Integer id;
    String customerId;
    String title;
    String contents;
    InquiryStatus status;
    LocalDateTime regDate;
    LocalDateTime updateDate;


}
