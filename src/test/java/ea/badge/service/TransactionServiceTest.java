package ea.badge.service;

import ea.badge.domain.Role;
import ea.badge.domain.Transaction;
import ea.badge.repository.RoleRepository;
import ea.badge.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    List<Transaction> transactionList=new ArrayList<>();
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;


    @BeforeEach
    public void setup() {

        Transaction transaction1 = new Transaction(1L, LocalDateTime.now());
        Transaction transaction2 = new Transaction(2L, LocalDateTime.now());
        transactionList.add(transaction1);
        transactionList.add(transaction1);
    }

    @Test
    void addTransaction() {
            Transaction transaction3=new Transaction(3L, LocalDateTime.now());
            Mockito.when(transactionRepository.save(transaction3)).thenReturn(transaction3);
            Transaction actual=transactionService.addTransaction(transaction3);
            assertThat(actual).isEqualTo(transaction3);
        }


    @Test
    void findAll() {
        Mockito.when(transactionRepository.findAll()).thenReturn(transactionList);
        Collection<Transaction> actual = transactionService.findAll();
        assertThat(actual).isEqualTo(transactionList);

    }
}