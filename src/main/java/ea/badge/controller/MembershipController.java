package ea.badge.controller;


import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.domain.Membership;
import ea.badge.dto.MembershipDto;
import ea.badge.service.MemberService;
import ea.badge.service.MembershipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members/{memberId}/memberships")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    private Collection<MembershipDto> getMemberships(@PathVariable("memberId") Long memberId) {
        return membershipService.getMembershipByMemberId(memberId).stream()
                .map(membership -> mapper.map(membership, MembershipDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addMembership(@RequestBody Membership membership){
        membershipService.addMembership(membership);
    }

    @DeleteMapping("/{id}")
    public void removeMembership(@PathVariable("id") Long id){
        membershipService.removeMembership(id);
    }
}


