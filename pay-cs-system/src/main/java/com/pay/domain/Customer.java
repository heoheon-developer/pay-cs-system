package com.pay.domain;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    private String customerId; // 고객 ID

    private String customerName; // 고객 이름
    private String customerPhone; // 고객 전화
    @CreatedDate
    private LocalDateTime createAt; // 생성일
    @LastModifiedDate
    private LocalDateTime updateAt; // 수정일

}
