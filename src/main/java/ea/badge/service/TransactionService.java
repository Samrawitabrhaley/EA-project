package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    Transaction getById(Long id);
    Collection<Transaction> getTransactionsByMemberId(Long id);
    Collection<Transaction> getTransactionForNumberOfDaysByBadgeId(Long badgeId, int numberOfDays);
    List<Transaction> findAll();

    Transaction updateById(Transaction newTransaction, Long id);

     void deleteTransaction(Long id);
}
