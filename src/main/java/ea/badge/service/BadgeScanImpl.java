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
        Boolean transactionSucceed = false;
        Membership membership = membershipService.getMembershipByMemberIdAndByLocationId(badgeId, locationId);
        // TODO more logic, membership, plane

        transactionSucceed = Objects.nonNull(membership) ? true : false; // check if a member of this location

        transaction = transactionService.addTransaction(new Transaction(badgeService.findById(badgeId),membership.getLocation(), transactionSucceed));

        return transaction;
    }
}
