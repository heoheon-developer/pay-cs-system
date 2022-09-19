package com.pay.service;

import com.pay.domain.Inquiry;
import com.pay.dto.InquiryDto;
import com.pay.dto.request.InquiryCreateDto;
import com.pay.repository.InquiryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InquiryService {

    // 문의 목록 전체
    List<InquiryDto> findAll();

    // 문의 등록
    public Inquiry create(InquiryCreateDto inquiryCreateDto);
}
