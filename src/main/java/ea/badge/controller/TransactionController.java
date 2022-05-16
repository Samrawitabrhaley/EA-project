package ea.badge.controller;


import ea.badge.domain.Transaction;
import ea.badge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public void addTransaction(Transaction transaction){
        transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> list(){
        return transactionService.findAll();
    }
}
