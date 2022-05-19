package ea.badge.controller;
import ea.badge.domain.Transaction;
import ea.badge.dto.TransactionDto;
import ea.badge.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public TransactionDto addTransaction(@RequestBody TransactionDto transaction){
        return mapper.map(transactionService.addTransaction(mapper.map(transaction,
        Transaction.class)), TransactionDto.class);

    }

    @GetMapping
    public List<TransactionDto> list(){
        return this.transactionService.findAll().stream()
                .map(transaction -> mapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public TransactionDto getById(@PathVariable Integer id){
        return mapper.map(transactionService.getById(id), TransactionDto.class);
    }

    @PutMapping("/{id}")
    public TransactionDto update(@RequestBody Transaction newTransactional, @PathVariable(name="id") Integer id) {
        return mapper.map(this.transactionService.updateById(newTransactional,id),TransactionDto.class);
    }
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Integer id){
        transactionService.deleteTransaction(id);
    }

}
