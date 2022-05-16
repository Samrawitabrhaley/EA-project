package ea.badge.service;

import ea.badge.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    public void addTransaction(Transaction transaction);

    public List<Transaction> findAll();
}
