package com.pay.domain;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Getter
@ToString
@Entity
public class Counselor {

    private Integer id;
    private String counselorId; // 상담사 ID
    private String counselorPassword; // 비밀번호
    private String counselorName; // 상담사 이름
    private LocalDateTime createAt; // 생성일
    private LocalDateTime updateAt; // 수정일

}
