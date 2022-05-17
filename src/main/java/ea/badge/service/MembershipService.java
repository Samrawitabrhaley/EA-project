package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;

import java.util.Collection;
import java.util.List;

public interface MembershipService {
    void addMembership(Membership membership);
    void removeMembership(Long id);
    Collection<Membership> getMembershipByMemberId(Long memberId);
    Membership getMembershipByMemberIdAndByLocationId(Long memberId, Long locationId);
}
