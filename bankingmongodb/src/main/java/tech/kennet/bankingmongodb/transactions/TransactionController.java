package tech.kennet.bankingmongodb.transactions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/transactions")
@AllArgsConstructor
public class TransactionController {
    
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> fetchAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public void registerNewTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") String transactionId) {
        transactionService.deleteTransaction(transactionId);
    }

    @PutMapping(path = "{transactionId}")
    public void updateCustomer(@PathVariable("transactionId") String transactionId, @RequestParam(required = false) String from_account_id, @RequestParam(required = false) String to_account_id, @RequestParam(required = false) LocalDateTime date_and_time, @RequestParam(required = false) Double amount) {
        transactionService.updateTransaction(transactionId, from_account_id, to_account_id, date_and_time, amount);
    }
}
