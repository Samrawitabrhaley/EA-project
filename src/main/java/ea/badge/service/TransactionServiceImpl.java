package ea.badge.service;

import ea.badge.domain.Transaction;
import ea.badge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
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
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

}
