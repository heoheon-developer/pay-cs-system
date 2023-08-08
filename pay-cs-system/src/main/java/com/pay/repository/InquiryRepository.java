package com.pay.repository;

import com.pay.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@RepositoryRestResource
@Repository
@CrossOrigin
public interface InquiryRepository extends
        JpaRepository<Inquiry, Integer>,
        QuerydslPredicateExecutor<Inquiry>
{
    public List<Inquiry> findAllByOrderByUpdateDateDesc();
}
