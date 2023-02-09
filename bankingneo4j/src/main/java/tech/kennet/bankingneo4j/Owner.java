package tech.kennet.bankingneo4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Owner {

    @Id @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    private List<String> owners = new ArrayList<>();

    @TargetNode
    private Customer customer;

    public List<String> getOwners() {
        return owners;
    }

    public Customer getCustomer() {
        return customer;
    }

}

