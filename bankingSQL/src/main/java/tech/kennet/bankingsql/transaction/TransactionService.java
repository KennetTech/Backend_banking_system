package tech.kennet.bankingsql.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.kennet.bankingsql.account.AccountRepository;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }


    public Optional<Transaction> getTransacation(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }


    public void addNewTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }


    public void deleteTransaction(Long transactionId) {
        Boolean exists = transactionRepository.existsById(transactionId);
        if (!exists) {
            throw new IllegalStateException("transaction with id " + transactionId + "does not exists");
        }
        transactionRepository.deleteById(transactionId);
    }


    public void updateTransaction(Long transactionId, Long from_account_id, String to_account_id, LocalDateTime dateAndTime,
            double amount) {
                Transaction transaction = transactionRepository.findById(transactionId).
                orElseThrow(() -> new IllegalStateException(
                    "transaction with Id " + transactionId + "does not exists"
                ));

                if (from_account_id != null && accountRepository.existsById(from_account_id)) {
                    transaction.setFrom_account_id(from_account_id);
                }

                if (to_account_id != null) {
                    transaction.setTo_account_id(to_account_id);
                }

                if (dateAndTime != null) {
                    transaction.setDateAndTime(dateAndTime);
                }

                if (Double.isNaN(amount)) {
                    transaction.setAmount(amount);
                }
    }

    
    
}
