package tech.kennet.bankingsystem.account;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerAccount(AccountRepository repository) {
        return args -> {

            /*
            Account a = new Account(
                "denStoreLomme",
                2002.32, 
                LocalDate.of(1994, Month.AUGUST, 21), 
                1L
            );
            
            Account b = new Account(
                "denlilleLomme",
                2002.32, 
                LocalDate.of(1994, Month.AUGUST, 21), 
                1L
            );

            repository.saveAll(
                List.of(a,b)
            );

             */
        };
    }
}
