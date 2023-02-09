package tech.kennet.bankingneo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRepository extends Neo4jRepository<Customer, Long> {
    
    
}
