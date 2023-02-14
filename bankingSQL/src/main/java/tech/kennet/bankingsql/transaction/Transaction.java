package tech.kennet.bankingsql.transaction;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @Column(name = "transactionId")
    @GeneratedValue
    private Long id;
    
    private Long from_account_id;
    private Long to_account_id;
    private LocalDate dateAndTime;
    private double amount;
    
    
    public Transaction(Long id, Long from_account_id, Long to_account_id, LocalDate dateAndTime, double amount) {
        this.id = id;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
        this.dateAndTime = dateAndTime;
        this.amount = amount;
    }


    public Transaction() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getFrom_account_id() {
        return from_account_id;
    }


    public void setFrom_account_id(Long from_account) {
        this.from_account_id = from_account;
    }


    public Long getTo_account_id() {
        return to_account_id;
    }


    public void setTo_account_id(Long to_account_id) {
        this.to_account_id = to_account_id;
    }


    public LocalDate getDateAndTime() {
        return dateAndTime;
    }


    public void setDateAndTime(LocalDate dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

}
