package com.seoyun.hello;

import com.seoyun.hello.repository.MemberRepository;
import com.seoyun.hello.repository.MemoryMemberRepository;
import com.seoyun.hello.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /* 직접 빈을 주입하는 방법
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */

}
