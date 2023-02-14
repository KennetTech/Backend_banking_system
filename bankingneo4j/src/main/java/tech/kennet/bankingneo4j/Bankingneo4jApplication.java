package tech.kennet.bankingneo4j;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class Bankingneo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bankingneo4jApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(CustomerRepository customerRepository, AccountRepository accountRepository) {
		return args -> {

			Faker faker = new Faker();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("2023-01-01"); 
			
			customerRepository.deleteAll();

			accountRepository.deleteAll();

			for (int i = 0; i <= 49; i++) {
				Customer customer = new Customer(
					faker.name().firstName(),
					faker.name().lastName(), 
					faker.internet().emailAddress(), 
					faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
					);
				
				Account account = new Account(
					faker.name().name(), 
					Double.valueOf(faker.number().numberBetween(2000, 7000)), 
					faker.date().between(Date.from(customer.getDate_of_birth().atStartOfDay(ZoneId.systemDefault()).toInstant()), date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
					);

				List<Account> accountList = new ArrayList<Account>();
				accountList.add(account);
				customer.setCustomerAccounts(accountList);

				List<Customer> customerList = new ArrayList<Customer>();
				customerList.add(customer);
				account.setHasOwners(customerList);

				customerRepository.save(customer);
				accountRepository.save(account);

			}

			
		};
	}

}
