package tech.kennet.bankingsystem.transaction;


import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
    
    @Id
    @SequenceGenerator(
        name = "transaction_sequence",
        sequenceName = "transaction_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "transaction_sequence"
    )
    private Long id;
    private Long from_account;
    private int to_accountId;
    private LocalDate dateAndTime;
    private double amount;
    
    
    public Transaction(Long id, Long from_account, int to_accountId, LocalDate dateAndTime, double amount) {
        this.id = id;
        this.from_account = from_account;
        this.to_accountId = to_accountId;
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


    public Long getFrom_account() {
        return from_account;
    }


    public void setFrom_account(Long from_account) {
        this.from_account = from_account;
    }


    public int getTo_accountId() {
        return to_accountId;
    }


    public void setTo_accountId(int to_accountId) {
        this.to_accountId = to_accountId;
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
