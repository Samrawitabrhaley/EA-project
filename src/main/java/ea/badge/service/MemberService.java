package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.domain.Plan;
import ea.badge.domain.Transaction;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface MemberService {
    Member createMember(Member member);
    Collection<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteById(Long id);
    Member updateById(Member member,Long id);

    Collection<Badge> getMemberBadges(Long memberId);
    Badge getMemberActiveBadge(Long memberId);
    Badge createOrUpdateBadge(Long memberId, Badge badge);
    Badge replaceBadge(Long memberId, Long badgeId, Badge badge);
    Badge activateBadge(Long id);
    Badge deactivateBadge(Long id);

    Collection<Transaction> getTransactionsByMemberId(Long id);
//    Collection<Plan> getPlansByMemberId(Long memberId);
}
