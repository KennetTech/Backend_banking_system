package tech.kennet.bankingmongodb.customers;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String>{

    Optional<Customer> findCustomerByEmail(String email);
    
}
