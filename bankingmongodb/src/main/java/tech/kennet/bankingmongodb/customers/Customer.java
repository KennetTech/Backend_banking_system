package tech.kennet.bankingmongodb.customers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Customer {

    public Customer(String first_name, String last_name, String email, LocalDate date_of_birth, String customertype_id, String branch_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.customertype_id = customertype_id;
        this.branch_id = branch_id;
    }

    @Id
    private String id;

    private String first_name;
    private String last_name;
    private String email;
    private LocalDate date_of_birth;
    private String customertype_id;
    private String branch_id;    

}
