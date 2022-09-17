package com.pay.repository;

import com.pay.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}
