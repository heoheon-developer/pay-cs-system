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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "customerId"),
        @Index(columnList = "title"),
        @Index(columnList = "contents"),
        @Index(columnList = "regDate")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(nullable = false)
    private String customerId; // 고객 ID
    @Setter
    @Column(nullable = false)
    private String title; // 제목
    @Setter
    @Column(nullable = false, length = 10000)
    private String contents; // 문의 내용
    // 문의 답변 바인딩
    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "inquiry")
    private final Set<InquiryAnswer> inquiryAnswer = new LinkedHashSet<>();

    @Setter
    @Column(nullable = false)
    private InquiryStatus status; // 문의 상태
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate; // 생성일
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateDate; // 수정일

    protected Inquiry(){
    }

    private Inquiry(String customerId, String title, String contents, InquiryStatus status) {
        this.customerId = customerId;
        this.title = title;
        this.contents = contents;
        this.status = status;
    }

    public static Inquiry of(String customerId, String title, String contents, InquiryStatus status){
        return new Inquiry(customerId, title, contents, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquiry inquiry = (Inquiry) o;
        return id != null && id.equals(inquiry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
