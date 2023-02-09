package tech.kennet.bankingmongodb.customers;

import java.time.ZoneId;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;


@Configuration
public class CustomerConfig {

    

    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository) {
        return args -> {

            Faker faker = new Faker();

            Customer customer = new Customer(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                Integer.toString(faker.number().numberBetween(1, 2)),
                Integer.toString(faker.number().numberBetween(1, 2))


                );

            repository.save(customer);
                       
        };
    }
}
