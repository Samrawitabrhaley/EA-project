package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.service.BadgeService;
import ea.badge.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member){
     return memberService.createMember(member);
    }

    @GetMapping
    public Collection<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteById(id);
    }
    @PutMapping()
    public Member updateMember(@Valid @RequestBody Member member, @PathVariable Long id){
       return memberService.updateById(member,id);
    }
    @PostMapping("/{id}/badges")
    @PutMapping("/{id}/badges")
    public Badge createOrUpdate(@RequestBody Badge badge) {
        return memberService.createOrUpdate(badge);
    }
    @PostMapping("/{id}/badges/replace")
    public Badge replaceBadge(@RequestBody Badge bagde){
        return memberService.replaceBadge(bagde);
    }
    @PutMapping("/{id}/badges/deactivate")
    public Badge deactivateBadge(@RequestBody Badge badge){
        return memberService.deactivateBadge(badge.getId());
    }



}
