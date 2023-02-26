package com.shop.shop.service;

import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;

public interface  MemberService {

    Member saveMember(Member member);
}
