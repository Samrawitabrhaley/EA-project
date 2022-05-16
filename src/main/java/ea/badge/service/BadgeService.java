package ea.badge.service;

import ea.badge.domain.Badge;

import java.util.Collection;

public interface BadgeService {
    Collection<Badge> findAll();
    Badge findById(Integer id);
    Collection<Badge> findByMemberId(Integer id);
    Badge createOrUpdate(Badge badge);
    Badge replaceWithNew(Badge newBadge);
    Badge deactivateById(Integer id);
    Badge activateById(Integer id);
    void deleteById(Integer id);
}
