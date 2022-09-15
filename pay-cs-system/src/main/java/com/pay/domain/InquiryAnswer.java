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
public class InquiryAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @ManyToOne(optional = false)
    private Inquiry inquiry; // 해당문의
    @Setter
    @OneToOne(optional = false)
    private Counselor counselor; // 상담사
    @Column
    private String contents; // 답변 내용
    @CreatedDate
    private LocalDateTime createAt; // 생성일
    @LastModifiedDate
    private LocalDateTime updateAt; // 수정일
    
}
