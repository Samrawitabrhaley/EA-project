package ea.badge.service;

import ea.badge.domain.Badge;

import java.util.Collection;

public interface BadgeService {
    Collection<Badge> findAll();
    Badge findById(Long id);
    Collection<Badge> findByMemberId(Long id);
    Badge createOrUpdate(Badge badge);
    Badge replaceWithNew(Badge newBadge);
    Badge deactivateById(Long id);
    Badge activateById(Long id);
    void deleteById(Long id);
}
