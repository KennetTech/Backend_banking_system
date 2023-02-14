package tech.kennet.bankingsql.customer;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import tech.kennet.bankingsql.account.Account;
import tech.kennet.bankingsql.account.AccountRepository;


@Configuration
public class CustomerConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository, AccountRepository accountRepository) {
        return args -> {

            Faker faker = new Faker();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("1950-01-01");
            Date date2 = dateFormat.parse("2023-01-01"); 

            for (int i = 0; i <= 49; i++) {
                Customer customer = new Customer(
                    faker.name().firstName() + " " + faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                    );

                    Account a = new Account(
                        faker.name().name(),
                        faker.number().numberBetween(0, 5000), 
                        faker.date().between(date, date2).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
                        1L
                    );

                customer.getAccounts().add(a);
                a.getCustomers().add(customer);
    
                repository.save(customer);
                accountRepository.save(a);
            }
            
        };
    }
}
