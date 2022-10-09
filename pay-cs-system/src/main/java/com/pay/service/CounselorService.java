package com.pay.service;

import com.pay.domain.Counselor;
import org.springframework.security.core.userdetails.UserDetails;

public interface CounselorService {

    Counselor getCounselorByCounselorId(String id);

    public UserDetails loadUserByUsername(String userId);


}
