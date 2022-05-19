package ea.badge.service;

import ea.badge.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class BadgeScanImpl implements BadgeScanService {
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BadgeService badgeService;

    @Override
    public Transaction scan(Long badgeId, Long locationId) {
        Transaction transaction = null;
        Boolean transactionSucceed = true;
        Membership membership = membershipService.getMembershipByMemberIdAndByLocationId(badgeId, locationId);

        if (Objects.nonNull(membership)) {
            Rule rule = membership.getPlan().stream().findFirst().get().getRule();
            int numberOfTransaction = transactionService.getTransactionForNumberOfDaysByBadgeId(badgeId, rule.getPerDurationDays()).size();
            if (numberOfTransaction > rule.getAllowedLimit()) {
                transactionSucceed = false;
            }
        } else {
            transactionSucceed = false;
        }

        transaction = transactionService.addTransaction(new Transaction(badgeService.findById(badgeId), membership.getLocation(), transactionSucceed));

        return transaction;
    }
}