package tech.kennet.bankingmongodb.transactions;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("transactions")
public class Transaction {
    
    public Transaction(String id, String iban, LocalDateTime localDate, double randomDouble) {
        this.from_account_id = id;
        this.to_account_id = iban;
        this.date_and_time = localDate;
        this.amount = randomDouble;
    }

    @Id
    private String id;

    private String from_account_id;
    private String to_account_id;
    private LocalDateTime date_and_time;
    private Double amount;
}