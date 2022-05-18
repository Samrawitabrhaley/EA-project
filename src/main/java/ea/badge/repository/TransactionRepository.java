package ea.badge.repository;

import ea.badge.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query("FROM Transaction t WHERE t.badge.member.id = :id")
    Collection<Transaction> getTransactionsByMemberId(Long id);
}
