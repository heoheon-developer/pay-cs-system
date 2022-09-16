package com.pay.domain;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@ToString
@Entity
public class Counselor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Setter
    @Column(nullable = false)
    private String counselorId; // 상담사 ID
    @Setter
    @Column(nullable = false)
    private String counselorPassword; // 비밀번호
    @Setter
    @Column(nullable = false)
    private String counselorName; // 상담사 이름
    @CreatedDate
    private LocalDateTime createAt; // 생성일
    @LastModifiedDate
    private LocalDateTime updateAt; // 수정일

}
