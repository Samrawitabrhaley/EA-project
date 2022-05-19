package ea.badge.service;

import ea.badge.domain.*;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.PlanRepository;
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
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PlanRepository planRepository;

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
    public Collection<Badge> getMemberBadges(Long memberId) {
        return badgeService.findByMemberId(memberId);
    }

    @Override
    public Badge getMemberActiveBadge(Long memberId) {
        return badgeService.findActiveBadgeByMemberId(memberId);
    }

    @Override
    public Badge createOrUpdateBadge(Long memberId, Badge badge) {
        return badgeService.createOrUpdate(getMemberById(memberId), badge);
    }

    @Override
    public Badge replaceBadge(Long memberId, Long badgeId, Badge badge) {
        return badgeService.replaceWithNew(getMemberById(memberId), badgeId, badge);
    }

    @Override
    public Badge activateBadge(Long id) {
        return badgeService.activateById(id);
    }

    @Override
    public Badge deactivateBadge(Long id) {
        return badgeService.deactivateById(id);
    }

    @Override
    public Collection<Transaction> getTransactionsByMemberId(Long id) {
        return transactionService.getTransactionsByMemberId(id);
    }

    @Override
    public Collection<Membership> getPlansByMemberId(Long memberId) {
        return planRepository.getPlansByMemberId(memberId);
    }
}
