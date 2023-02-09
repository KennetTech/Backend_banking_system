package tech.kennet.bankingsql.overdraft;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tech.kennet.bankingsql.account.Account;

@Entity
@Table
public class Overdraft {
    
    @Id
    @Column(name = "overdraft_id")
    @GeneratedValue
    private Long id;

    private LocalDateTime dateTime;
    private double amount;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Overdraft(LocalDateTime dateTime, double amount, Account account) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.account = account;
    }

    public Overdraft(LocalDateTime dateTime, double amount) {
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
