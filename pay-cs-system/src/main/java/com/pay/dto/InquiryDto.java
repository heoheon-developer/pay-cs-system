package com.pay.dto;

import com.pay.enums.InquiryStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryDto implements Serializable {

    Integer id;
    String customerId;
    String title;
    String contents;
    InquiryStatus status;
    LocalDateTime regDate;
    LocalDateTime updateDate;


}
