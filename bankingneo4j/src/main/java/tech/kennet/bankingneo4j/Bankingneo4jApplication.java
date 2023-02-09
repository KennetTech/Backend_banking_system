package tech.kennet.bankingneo4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bankingneo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bankingneo4jApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(CustomerRepository customerRepository, AccountRepository accountRepository) {
		return args -> {
			
			customerRepository.deleteAll();
			Customer kennet = new Customer("kennet", "christiansen", "kc@fakemail.com", LocalDate.parse("25/02/1986", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			customerRepository.save(kennet);

			accountRepository.deleteAll();

			Account lonkonto = new Account("lonkonto", 2500.0);

			accountRepository.save(lonkonto);



		};
	}

}
