package com.pay.repository;

import com.pay.domain.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounselorRepository extends JpaRepository<Counselor, Integer> {

    Optional<Counselor> findCounselorByCounselorId(String id);

}
