package com.seoyun.hello.controller;

import com.seoyun.hello.domain.Member;
import com.seoyun.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    @Autowired private MemberService memberService; 이건 필드주입방식인데 잘 안씀. 테스트할 때 주로 씀

    /* 이건 setter주입방식. 퍼블릭이니까 중간에 잘못 건들면 망가지므로 잘 안씀.
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    private static MemberService memberService;

    @Autowired // 생성자가 하나면 생략가능
    public MemberController(MemberService memberService) {  // 생성자주입방식. 안전하므로 이걸 주로 씀.
        this.memberService = memberService;
    }


    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) { // 폼 값의 객체를 미리 생성해서 그걸로 받았음.(모델?)
        Member member = new Member();
        member.setName(form.getName());

        /* soutv */
        System.out.println("member = " + member.getName());



        memberService.join(member);

        return "redirect:/";
    }

}
