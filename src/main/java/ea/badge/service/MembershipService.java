package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;

import java.util.List;

public interface MembershipService {
    public void addMembership(Membership membership);
    public void removeMembership(Long id);
    public Badge createBadge(Badge badge);
    public Badge replaceBadge(Badge bagde);
    public Badge deactivateBadge(Integer id);
    }
