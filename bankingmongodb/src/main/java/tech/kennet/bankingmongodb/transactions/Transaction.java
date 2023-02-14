package tech.kennet.bankingmongodb.transactions;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("transactions")
public class Transaction {
    
    @Id
    private String id;

    private String from_account_id;
    private String to_account_id;
    private LocalDateTime date_and_time;
    private Double amount;
}