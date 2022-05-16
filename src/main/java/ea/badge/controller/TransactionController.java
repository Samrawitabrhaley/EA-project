package ea.badge.controller;


import ea.badge.domain.Transaction;
import ea.badge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> list(){
        return transactionService.findAll();
    }
}
