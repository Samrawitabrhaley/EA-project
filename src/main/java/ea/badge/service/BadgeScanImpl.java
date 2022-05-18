package ea.badge.service;

import ea.badge.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class BadgeScanImpl implements BadgeScan {
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BadgeService badgeService;

    @Override
    public Transaction scan(Long badgeId, Long locationId) {
        Transaction transaction = null;
        Membership membership = membershipService.getMembershipByMemberIdAndByLocationId(badgeId, locationId);
        if(Objects.nonNull(membership)) {
            transaction = transactionService.addTransaction(new Transaction(badgeService.findById(badgeId),membership.getLocation(), true));
        } else {
            transaction = transactionService.addTransaction(new Transaction(badgeService.findById(badgeId),membership.getLocation(), false));
        }

        return transaction;
    }
}
