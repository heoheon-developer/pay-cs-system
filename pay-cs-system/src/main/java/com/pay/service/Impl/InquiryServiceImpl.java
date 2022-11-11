package com.pay.service.Impl;

import com.pay.domain.Inquiry;
import com.pay.dto.InquiryDto;
import com.pay.dto.request.InquiryCreateDto;
import com.pay.enums.InquiryStatus;
import com.pay.repository.InquiryRepository;
import com.pay.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public List<InquiryDto> findAll() {
        List<Inquiry> list = this.inquiryRepository.findAll();
        log.info("inquiryList == " + list);
        ModelMapper modelMapper = new ModelMapper();
        return Arrays.asList(modelMapper.map(list, InquiryDto[].class));
    }

    @Override
    public Inquiry create(InquiryCreateDto inquiryCreateDto) {

        log.debug("service====>", inquiryCreateDto.getContents());
        Inquiry inquiry = Inquiry.of(inquiryCreateDto.getCustomerId(), inquiryCreateDto.getTitle(), inquiryCreateDto.getContents(), InquiryStatus.WATTING);

        return inquiryRepository.save(inquiry);
    }

    @Override
    public InquiryDto getDetail(Integer id) {

        Inquiry inquiry = inquiryRepository.findById(id).orElseThrow(() -> new RuntimeException("상담글 찾을 수 없습니다."));

        return InquiryDto.builder()
                .contents(inquiry.getContents())
                .customerId(inquiry.getCustomerId())
                .title(inquiry.getTitle())
                .build();
    }
}
