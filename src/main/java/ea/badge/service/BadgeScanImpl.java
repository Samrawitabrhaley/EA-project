package ea.badge.service;

import ea.badge.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BadgeScanImpl implements BadgeScan {
    @Autowired
    private MembershipService membershipService;

    @Override
    public Transaction scan(Long badgeId, Long locationId) {
        // get the rule of a plan for a location where this member is a member
        System.out.println( "membership type: " +
        membershipService.getMembershipByMemberIdAndByLocationId(badgeId, locationId).getMembershipType()
        );
        return null;
    }
}
