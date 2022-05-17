package ea.badge.service;

import ea.badge.domain.Membership;
import ea.badge.domain.MembershipType;
import ea.badge.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeScanImpl implements BadgeScan {
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private TransactionService transactionService;

    @Override
    public Transaction scan(Long badgeId, Long locationId) {
        // get the rule of a plan for a location where this member is a member
        Membership membership = membershipService.getMembershipByMemberIdAndByLocationId(badgeId, locationId);
        if(membership.getMembershipType() == MembershipType.CHECKER)
            return transactionService.findAll().get(1);

        return null;
    }
}
