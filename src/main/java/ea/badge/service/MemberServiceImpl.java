package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BadgeService badgeService;

    @Override
    public Member createMember(Member member) {
       return memberRepository.save(member);
    }

    @Override
    public Collection<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    @Override
    public Member getMemberById(Long id) {
        return memberRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);

    }

    @Override
    public Member updateById(Member member,Long id) {
        if(memberRepository.findById(id).isPresent()) {
            return memberRepository.save(member);
        } else{
            throw new RuntimeException("Member Not Found");
        }

    }

    @Override
    public Badge createOrUpdate(Badge badge) {
        return badgeService.createOrUpdate(badge);
    }

    @Override
    public Badge replaceBadge(Badge badge) {
        return badgeService.replaceWithNew(badge);
    }

    @Override
    public Badge deactivateBadge(Integer id) {
        return badgeService.deactivateById(id);
    }
}
