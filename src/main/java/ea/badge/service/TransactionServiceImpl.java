package ea.badge.service;

import ea.badge.domain.Transaction;
import ea.badge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Collection<Transaction> getTransactionsByMemberId(Long id) {
        return transactionRepository.getTransactionsByMemberId(id);
    }

    @Override
    public Collection<Transaction> getTransactionForNumberOfDaysByBadgeId(Long badgeId, int numberOfDays) {
        return transactionRepository.getTransactionForNumberOfDaysByBadgeId(badgeId, LocalDateTime.now().minusDays(numberOfDays));
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

}
