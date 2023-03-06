package com.shop.shop.service;

import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Member saveMember(Member member);
}
