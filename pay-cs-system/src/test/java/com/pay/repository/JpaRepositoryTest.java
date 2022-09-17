package com.pay.repository;

import com.pay.config.JpaConfig;
import com.pay.domain.Inquiry;
import com.pay.enums.InquiryStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Jpa 연결테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private InquiryRepository inquiryRepository;
    private InquiryAnswerRepository inquiryAnswerRepository;

    // 생성자 주입 패턴
    public JpaRepositoryTest(
            @Autowired InquiryRepository inquiryRepository,
            @Autowired InquiryAnswerRepository inquiryAnswerRepository) {
        this.inquiryRepository = inquiryRepository;
        this.inquiryAnswerRepository = inquiryAnswerRepository;
    }

    @DisplayName("문의 전체 select")
    @Test
    void givenTestData_whenSelect_thenWorksFine(){
        // given
        // data.sql 에 데이터를 사전에 입력

        // when
        List<Inquiry> inquiryList = inquiryRepository.findAll();

        // then
        assertThat(inquiryList).isNotNull().hasSize(1);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInsert_thenWorksFine(){

        // Given
        long previousCount = inquiryRepository.count();

         // When
        Inquiry savedInquiry = inquiryRepository.save(Inquiry.of("heoheon", "test","test", InquiryStatus.INQUIRY_WATTING));

        // Then
        assertThat(inquiryRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdate_thenWorksFine(){

        // Given
        Inquiry savedInquiry = inquiryRepository.save(Inquiry.of("heoheon","test","test", InquiryStatus.INQUIRY_WATTING));
        Inquiry inquiryUpdate = inquiryRepository.findById(savedInquiry.getId()).orElseThrow();
        String updateTitle = "제목변경";
        inquiryUpdate.setTitle(updateTitle);

        // When
        Inquiry updateInquiry = inquiryRepository.saveAndFlush(inquiryUpdate);

        // Then
        assertThat(updateInquiry).hasFieldOrPropertyWithValue("title", updateTitle);

    }


}