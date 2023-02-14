package tech.kennet.bankingmongodb.accounts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.kennet.bankingmongodb.customers.CustomerRepository;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunnerAccount(CustomerRepository customerRepository, AccountRepository accountRepository) {
        return args -> {

      

            
                       
        };
    }
    
}
