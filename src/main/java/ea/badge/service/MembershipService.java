package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;

import java.util.List;

public interface MembershipService {
    public Membership addMembership(Membership membership);
    public void removeMembership(Long id);

    }
