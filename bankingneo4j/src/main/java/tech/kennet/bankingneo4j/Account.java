package tech.kennet.bankingneo4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Node
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String account_name;
    private Double balance;
    private LocalDate date_opened;
    
    @Relationship(type = "HAS_OWNER")
    @JsonIgnoreProperties("customerAccounts")
    public List<Customer> hasOwners = new ArrayList<>();

    public Account(String account_name, Double balance, LocalDate date_opened) {
        this.account_name = account_name;
        this.balance = balance;
        this.date_opened = date_opened;
    }

    public Account() {
    }

    public Account(String account_name, Double balance) {
        this.account_name = account_name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getDate_opened() {
        return date_opened;
    }

    public void setDate_opened(LocalDate date_opened) {
        this.date_opened = date_opened;
    }

    public List<Customer> getHasOwners() {
        return hasOwners;
    }

    public void setHasOwners(List<Customer> hasOwners) {
        this.hasOwners = hasOwners;
    }

}
