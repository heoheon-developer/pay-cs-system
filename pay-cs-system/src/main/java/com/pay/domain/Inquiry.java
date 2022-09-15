package com.pay.domain;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Customer customer; // 고객
    @Setter
    @Column(nullable = false)
    private String title; // 제목
    @Setter
    @Column(nullable = false)
    private String contents; // 문의 내용
    @Setter
    private InquiryStatus status; // 문의 상태
    private LocalDateTime createAt; // 생성일
    private LocalDateTime updateAt; // 수정일

    protected Inquiry(){

    }

    private Inquiry(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


    public static Inquiry of(String title, String contents){
        return new Inquiry(title, contents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquiry inquiry = (Inquiry) o;
        return id !=null && id.equals(inquiry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
