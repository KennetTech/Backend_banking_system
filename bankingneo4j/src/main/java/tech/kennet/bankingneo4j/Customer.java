package tech.kennet.bankingneo4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class Customer {

    @Id @GeneratedValue
    private Long id;

    private String first_name;
    private String last_name;
    private String email;
    private LocalDate date_of_birth;
    private String customertype_id;
    private String branch_id;

    @Relationship(type = "HAS_OWNER", direction = Direction.INCOMING)
    private List<Owner> hasOwner = new ArrayList<>();

    public Customer(String first_name, String last_name, String email, LocalDate date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCustomertype_id() {
        return customertype_id;
    }

    public void setCustomertype_id(String customertype_id) {
        this.customertype_id = customertype_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public List<Owner> getHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(List<Owner> hasOwner) {
        this.hasOwner = hasOwner;
    }
    
}
