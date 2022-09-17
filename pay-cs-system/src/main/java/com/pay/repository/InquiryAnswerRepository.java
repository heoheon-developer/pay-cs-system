package com.pay.repository;

import com.pay.domain.Inquiry;
import com.pay.domain.InquiryAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InquiryAnswerRepository extends JpaRepository<InquiryAnswer, Integer> {
}
