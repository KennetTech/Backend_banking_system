package tech.kennet.bankingsystem.customer;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.kennet.bankingsystem.account.Account;


@Configuration
public class CustomerConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository) {
        return args -> {
            Customer alex = new Customer(
                    "Alex",
                    "Alex.andersen@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 21),
                    1L
            );
            
            Account a = new Account(
                "denStoreLomme",
                2002.32, 
                LocalDate.of(1994, Month.AUGUST, 21), 
                1L
            );

            alex.getAccounts().add(a);

            a.getCustomers().add(alex);

            repository.save(alex);

            /*
            repository.saveAll(
                List.of(catja, torben)
            );
            */
        };
    }
}
