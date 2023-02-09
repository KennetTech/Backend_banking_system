package tech.kennet.bankingsql.account;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tech.kennet.bankingsql.customer.Customer;

@Entity
@Table
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Customer> customers = new HashSet<Customer>();

    private String name;
    private double ballance;
    private LocalDate accountOpened;
    private Long accountType;



    public Account() {
    }
    
    public Account(String name, double ballance, LocalDate accountOpened, Long id) {
        this.name = name;
        this.ballance = ballance;
        this.accountOpened = accountOpened;
        this.accountType = id;
    }
    public Account(Long id, String name, double ballance, LocalDate accountOpened, Long accountType) {
        this.id = id;
        this.name = name;
        this.ballance = ballance;
        this.accountOpened = accountOpened;
        this.accountType = accountType;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBallance() {
        return ballance;
    }
    public void setBallance(double ballance) {
        this.ballance = ballance;
    }
    public LocalDate getAccountOpened() {
        return accountOpened;
    }
    public void setAccountOpened(LocalDate accountOpened) {
        this.accountOpened = accountOpened;
    }
    public Long getAccountType() {
        return accountType;
    }
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    
}
