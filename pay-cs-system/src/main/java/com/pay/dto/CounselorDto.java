package com.pay.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class CounselorDto {

    Integer counselorId;
    String password;
    String counselorName;
    LocalDateTime regDate;
    LocalDateTime updateDate;

}
