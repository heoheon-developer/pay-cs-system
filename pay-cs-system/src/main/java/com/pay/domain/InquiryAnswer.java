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
@Table(indexes = {
        @Index(columnList = "contents"),
        @Index(columnList = "regDate")
})
@EntityListeners(AuditingEntityListener.class)
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
    @Column(nullable = false)
    private String contents; // 답변 내용
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate; // 생성일
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateDate; // 수정일

    protected InquiryAnswer() {
    }
    public InquiryAnswer(Inquiry inquiry, Counselor counselor, String contents) {
        this.inquiry = inquiry;
        this.counselor = counselor;
        this.contents = contents;
    }

    public static InquiryAnswer of(Inquiry inquiry, Counselor counselor, String contents){
        return new InquiryAnswer(inquiry, counselor, contents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InquiryAnswer that = (InquiryAnswer) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
