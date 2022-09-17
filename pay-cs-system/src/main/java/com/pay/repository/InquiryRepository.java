package com.pay.repository;

import com.pay.domain.Inquiry;
import com.pay.domain.QInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InquiryRepository extends
        JpaRepository<Inquiry, Integer>,
        QuerydslPredicateExecutor<Inquiry>
{
}
