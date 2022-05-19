package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Transaction;
import ea.badge.exception.ResourceNotFoundException;
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
    public Transaction getById(Long id) {
        return transactionRepository.getById(id);
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

    @Override
    public Transaction updateById(Transaction newTransaction, Long id) {
        return this.transactionRepository.findById(id).map(transaction ->{
            transaction.setBadge(newTransaction.getBadge());
            transaction.setDatetime(newTransaction.getDatetime());
            transaction.setLocation(newTransaction.getLocation());
            transaction.setSucceed(newTransaction.getSucceed());
            return transactionRepository.save(transaction);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
