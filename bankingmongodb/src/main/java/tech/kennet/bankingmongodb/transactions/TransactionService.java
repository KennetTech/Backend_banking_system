package tech.kennet.bankingmongodb.transactions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void addNewTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(String transactionId) {
        if (!transactionRepository.existsById(transactionId)) {
            throw new IllegalStateException(
                "transaction with id " + transactionId + " does not exists"
            );
        }
        transactionRepository.deleteById(transactionId);
    }

    public void updateTransaction(String transactionId, String from_account_id, String to_account_id,
            LocalDateTime date_and_time, Double amount) {
            Transaction transaction = transactionRepository.findById(transactionId)
            .orElseThrow(() -> new IllegalStateException(
                "transaction with id " + transactionId + " does not exists"
            ));

            if (from_account_id != null && from_account_id.length() > 0 && !Objects.equals(transaction.getFrom_account_id(), from_account_id)) {
                transaction.setFrom_account_id(from_account_id);
            }

            if (to_account_id != null && to_account_id.length() > 0 && !Objects.equals(transaction.getTo_account_id(), to_account_id)) {
                transaction.setTo_account_id(to_account_id);
            }

            if (date_and_time != null) {
                transaction.setDate_and_time(date_and_time);
            }

            if (amount != null && amount != 0) {
                transaction.setAmount(amount);
            }
    }

}
