package com.pay.service.Impl;

import com.pay.domain.Counselor;
import com.pay.repository.CounselorRepository;
import com.pay.service.CounselorService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class counselorServiceImpl implements CounselorService, UserDetailsService {
    private final CounselorRepository counselorRepository;
    public counselorServiceImpl(CounselorRepository counselorRepository) {
        this.counselorRepository = counselorRepository;
    }

    @Override
    public Counselor getCounselorByCounselorId(String id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Counselor counselor = counselorRepository.findByCounselorId(userId).orElseThrow(()->
        new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (counselor.getCounselorId().equals(userId)){

            authorities.add(new SimpleGrantedAuthority("ROLE_COUNSELOR"));
        }


        return new User(counselor.getCounselorId(), counselor.getCounselorPassword(), authorities);
    }
}
