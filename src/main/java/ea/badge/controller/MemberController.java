package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.domain.Membership;
import ea.badge.dto.*;
import ea.badge.service.BadgeService;
import ea.badge.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public MemberDto createMember(@RequestBody Member member){
        return mapper.map(memberService.createMember(mapper.map(member, Member.class)),
             MemberDto.class);
    }

    @GetMapping
    public Collection<MemberDto> getAllMembers(){
        return memberService.getAllMembers().stream()
                .map(member -> mapper.map(member, MemberDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{memberId}")
    public MemberDto getMemberById(@PathVariable("memberId") Long id){
        return mapper.map(memberService.getMemberById(id), MemberDto.class);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMemberById(@PathVariable("memberId") Long id){
        memberService.deleteById(id);
    }
    @PutMapping("/{memberId}")
    public MemberDto updateMember(@Valid @RequestBody MemberDto memberDto, @PathVariable("memberId") Long id){
       return mapper.map(memberService.updateById(mapper.map(memberDto, Member.class), id), MemberDto.class);
    }

    @PostMapping("/{memberId}/badges")
    @PutMapping("/{memberId}/badges")
    public BadgeDto createOrUpdateBadge(@PathVariable("memberId") Long memberId, @RequestBody Badge badge) {
        return mapper.map(memberService.createOrUpdateBadge(memberId, badge),
                BadgeDto.class);
    }
    @GetMapping("/{memberId}/badges")
    public Collection<BadgeDto> getMemberBadges(@PathVariable("memberId") Long id){
        return memberService.getMemberBadges(id).stream()
                .map(badge -> mapper.map(badge, BadgeDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/{memberId}/badges/{badgeId}/replace")
    public BadgeDto replaceBadge(@PathVariable("memberId") Long memberId, @PathVariable("badgeId") Long badgeId, @RequestBody Badge badge){
        return mapper.map(memberService.replaceBadge(memberId, badgeId, badge),BadgeDto.class);
//        return memberService.replaceBadge(bagde);
    }
    @PutMapping("/{memberId}/badges/{badgeId}/activate")
    public BadgeDto activateBadge(@PathVariable("badgeId") Long badgeId){
        return mapper.map(memberService.activateBadge(badgeId), BadgeDto.class);
//        return memberService.deactivateBadge(badge.getId());
    }

    @PutMapping("/{memberId}/badges/{badgeId}/deactivate")
    public BadgeDto deactivateBadge(@PathVariable("badgeId") Long badgeId){
        return mapper.map(memberService.deactivateBadge(badgeId), BadgeDto.class);
//        return memberService.deactivateBadge(badge.getId());
    }

    @GetMapping("/{memberId}/plans")
    public Collection<MembershipDto> getMemberPlans(@PathVariable("memberId") Long id){
        return memberService.getPlansByMemberId(id).stream()
                .map(membership -> mapper.map(membership, MembershipDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{memberId}/transactions")
    public Collection<TransactionDto> getMemberTransactions(@PathVariable("memberId") Long id){
        return memberService.getTransactionsByMemberId(id).stream()
                .map(transaction -> mapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }
}
