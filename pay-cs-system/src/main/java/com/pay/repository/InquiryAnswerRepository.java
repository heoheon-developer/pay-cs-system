package com.pay.repository;

import com.pay.domain.Inquiry;
import com.pay.domain.InquiryAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryAnswerRepository extends JpaRepository<InquiryAnswer, Integer> {
}
