package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;

import java.util.Collection;

public interface BadgeService {
    Collection<Badge> findAll();
    Badge findById(Long id);
    Collection<Badge> findByMemberId(Long id);
    Badge createOrUpdate(Member member, Badge badge);
    Badge replaceWithNew(Member member, Long oldBadge, Badge newBadge);
    Badge deactivateById(Long id);
    Badge activateById(Long id);
    void deleteById(Long id);

    Badge findActiveBadgeByMemberId(Long id);
    Collection<Badge> findInactiveBadgeByMemberId(Long id);
}
