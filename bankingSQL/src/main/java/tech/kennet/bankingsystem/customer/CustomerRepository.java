package tech.kennet.bankingsystem.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository 
                        extends JpaRepository<Customer, Long>{
    
            @Query("SELECT s FROM Customer s WHERE s.email = ?1")        
            Optional<Customer> findCustomerByEmail(String email);
}
