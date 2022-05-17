package ea.badge.controller;


import ea.badge.domain.Transaction;
import ea.badge.dto.TransactionDto;
import ea.badge.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    public TransactionDto addTransaction(@RequestBody TransactionDto transaction){
        return mapper.map(transactionService.addTransaction(mapper.map(transaction,
        Transaction.class)), TransactionDto.class);
//        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<TransactionDto> list(){
        return this.transactionService.findAll().stream()
                .map(transaction -> mapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
//        return transactionService.findAll();
    }
}
