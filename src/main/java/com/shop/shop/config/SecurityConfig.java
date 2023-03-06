package com.shop.shop.config;

import com.shop.shop.entity.Member;
import com.shop.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 자동으로 SpringSecurityFilterChain 포함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http 요청에 대한 보안 설정
        http.formLogin()
                .loginPage("/members/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/")
        ;

        http.authorizeRequests() // 시큐리티 처리에 HttpServletRequest를 이용하겠음
                .mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ;

        // 인증되지 않은 사용자가 리소스에 접근하면 수행되는 핸들러 등록
        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

    // spring security에서 인증은 AuthenticationManager를 통해 이루어지며 AuthenticationManagerBuilder가 AuthenticationManager를 생성
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        // userDetailService 구현 객체로 memberService를 지정해주며, 비밀번호 암호를 위해 passwordEncoder 지정
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }

    // static 디렉터리의 하위 파일은 인증을 무시하도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

}
