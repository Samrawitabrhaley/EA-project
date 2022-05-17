package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.dto.BadgeDto;
import ea.badge.dto.LocationDto;
import ea.badge.dto.MemberDto;
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

    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    public MemberDto createMember(@RequestBody Member member){
     return mapper.map(memberService.createMember(mapper.map(member, Member.class)),
             MemberDto.class);
    }

    @GetMapping
    public Collection<MemberDto> getAllMembers(){
        return this.memberService.getAllMembers().stream()
                .map(member -> mapper.map(member, MemberDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @Transactional
    public MemberDto getMemberById(@PathVariable Long id){
        return mapper.map(memberService.getMemberById(id), MemberDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id){
        memberService.deleteById(id);
    }
    @PutMapping({"/id"})
    public MemberDto updateMember(@Valid @RequestBody MemberDto memberDto, @PathVariable Long id){
       return mapper.map(memberService.updateById(mapper.map(memberDto, Member.class), id), MemberDto.class);
    }
    @PostMapping("/{id}/badges")
    @PutMapping("/{id}/badges")
    public BadgeDto createOrUpdate(@RequestBody BadgeDto badge) {
        return mapper.map(memberService.createOrUpdate(mapper.map(badge, Badge.class)),
                BadgeDto.class);
    }
    @PostMapping("/{id}/badges/replace")
    public BadgeDto replaceBadge(@RequestBody Badge badge){
        return mapper.map(memberService.replaceBadge(badge),BadgeDto.class);
//        return memberService.replaceBadge(bagde);
    }
    @PutMapping("/{id}/badges/deactivate")
    public BadgeDto deactivateBadge(@RequestBody Badge badge){
        return mapper.map(memberService.deactivateBadge(badge.getId()), BadgeDto.class);
//        return memberService.deactivateBadge(badge.getId());
    }



}
