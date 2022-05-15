package ea.badge.service;

import ea.badge.domain.Badge;

import java.util.Collection;

public interface BadgeService {
    Collection<Badge> findAll();
    Badge findById(Integer id);
    Collection<Badge> findByMemberId(Integer id);
    Badge create(Badge badge);
    Badge replaceWithNew(Badge newBadge);
    Badge deactivateById(Integer id);
}
