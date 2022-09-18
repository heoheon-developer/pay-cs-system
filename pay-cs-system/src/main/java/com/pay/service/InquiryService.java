package com.pay.service;

import com.pay.domain.Inquiry;
import com.pay.dto.request.InquiryDto;
import com.pay.repository.InquiryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InquiryService {
    List<InquiryDto> findAll();
}
