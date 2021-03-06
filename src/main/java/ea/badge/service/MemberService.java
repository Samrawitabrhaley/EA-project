package ea.badge.service;

import ea.badge.domain.*;

import java.util.Collection;

public interface MemberService {
    Member createMember(Member member);
    Collection<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteById(Long id);
    Member updateById(Member member,Long id);

    Collection<Badge> getMemberBadges(Long memberId);
    Badge getMemberBadgeByBadgeId(Long badgeId);
    Collection<Badge> getMemberActiveBadge(Long memberId);
    Badge createOrUpdateBadge(Long memberId, Badge badge);
    Badge replaceBadge(Long memberId, Long badgeId, Badge badge);
    Badge activateBadge(Long id);
    Badge deactivateBadge(Long id);

    Collection<Transaction> getTransactionsByMemberId(Long id);
    Collection<Membership> getPlansByMemberId(Long memberId);
}
