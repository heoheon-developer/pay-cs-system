package com.pay.domain;

import com.pay.enums.InquiryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Counselor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(nullable = false)
    private LocalDateTime regDate; // 생성일
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateDate; // 수정일

    protected Counselor() {
    }

    public Counselor(String counselorId, String counselorPassword, String counselorName) {
        this.counselorId = counselorId;
        this.counselorPassword = counselorPassword;
        this.counselorName = counselorName;
    }

    public static Counselor of(String counselorId, String counselorPassword, String counselorName) {
        return new Counselor(counselorId, counselorPassword, counselorName);
    }


    public Counselor(String id, String pw){
        this.counselorId = id;
        this.counselorPassword = pw;
    }

    public static Counselor of(String id, String pw){
        return new Counselor(id, pw);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counselor counselor = (Counselor) o;
        return id.equals(counselor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
