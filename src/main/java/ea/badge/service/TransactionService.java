package ea.badge.service;

import ea.badge.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    List<Transaction> findAll();
}
