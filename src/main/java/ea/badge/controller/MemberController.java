package ea.badge.controller;

import ea.badge.domain.Member;
import ea.badge.service.BadgeService;
import ea.badge.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public void addMember(Member member){
      memberService.addMember(member);
    }

    @GetMapping
    public List<Member> members(){
        return memberService.getMembers();
    }




}
