package tech.kennet.bankingsql.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @CrossOrigin
    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }
    
    @GetMapping(path = "{transactionId}")
    public Optional<Transaction> getTransaction(@PathVariable("transactionId") Long transactionId) {
        return transactionService.getTransacation(transactionId);
    }

    @PostMapping
    public void registerNewTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") Long transactionId) {
        transactionService.deleteTransaction(transactionId);
    }
    
    @PutMapping(path = "{transactionId}")
    public void updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestParam(required = false) Long from_account_id, @RequestParam(required = false) String to_account_id, @RequestParam(required = false) LocalDateTime dateAndTime, @RequestParam(required = false) double amount) {
        transactionService.updateTransaction(transactionId, from_account_id, to_account_id, dateAndTime, amount);        
    }

}
