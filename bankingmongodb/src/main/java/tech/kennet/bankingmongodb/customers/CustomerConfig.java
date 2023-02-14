package tech.kennet.bankingmongodb.customers;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import tech.kennet.bankingmongodb.accounts.Account;
import tech.kennet.bankingmongodb.accounts.AccountRepository;


@Configuration
public class CustomerConfig {

    

    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository customerRepository, AccountRepository accountRepository) {
        return args -> {

            Faker faker = new Faker();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("2023-01-01");

            customerRepository.deleteAll();
            accountRepository.deleteAll();

            for (int i = 0; i < 50; i++) {
                Customer customer = new Customer(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                Integer.toString(faker.number().numberBetween(1, 2)),
                Integer.toString(faker.number().numberBetween(1, 2))
                );

                customerRepository.save(customer);
            }

            List<Customer> customerList = customerRepository.findAll();

            for (Customer customer : customerList) {
                Account account = new Account(
                    faker.funnyName().name(),
                    faker.number().numberBetween(0, 65000),
                    faker.date().between(Date.from(customer.getDate_of_birth().atStartOfDay(ZoneId.systemDefault()).toInstant()), date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                );

                account.getOwner_id().add(customer.get_id());
                accountRepository.save(account);
            }           
                       
        };
    }
}
