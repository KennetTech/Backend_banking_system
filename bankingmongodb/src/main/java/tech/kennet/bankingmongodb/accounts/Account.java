package tech.kennet.bankingmongodb.accounts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Account {

    @Id
    private String id;

    private String account_name;
    private Double balance;
    private LocalDate date_opened;
    private List<String> owner_id;    
    
}
