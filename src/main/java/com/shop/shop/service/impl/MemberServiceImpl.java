package com.shop.shop.service.impl;

import com.shop.shop.entity.Member;
import com.shop.shop.repository.MemberRepository;
import com.shop.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// 비즈니스 로직을 담당하는 서비스 계층 클래스에 어노테이션 선언
@Transactional
// 빈을 주입하는 방법으로 @Autowired 어노테이션을 이용하거나, 필드 주입(Setter 주입), 생성자 주입을 이용하는 방법이 있가
// @RequiredArgsConstructor은 final이나 @NonNull이 붙은 필드에 생성자를 생성
@RequiredArgsConstructor
// MemeberService가 UserDetailsService를 구현
public class MemberServiceImpl implements MemberService{

    // 빈에 생성자가 1개이고 생성자의 파라미터 타입이 빈으로 등록가능하다면 @Autowired 없이 의존성 주입 가능
    private final MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        // UserDetail을 구현하고 있는 User 객체를 반환
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
