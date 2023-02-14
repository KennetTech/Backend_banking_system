package tech.kennet.bankingmongodb.accounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("accounts")
public class Account {

    @Id
    private String _id;

    private String account_name;
    private double balance;
    private LocalDate date_opened;
    private List<String> owner_id;

    public Account(String account_name, double balance, LocalDate date_opened) {
        this.account_name = account_name;
        this.balance = balance;
        this.date_opened = date_opened;
        this.owner_id = new ArrayList<>();
    }    
    
}
