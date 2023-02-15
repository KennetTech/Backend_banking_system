package tech.kennet.bankingmongodb.transactions;

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
public class TransactionConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerTransactions(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        return args -> {

            List<Account> accountslist = accountRepository.findAll();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("2023-01-01");

            Faker faker = new Faker();

            for (Account account : accountslist) {
                
                Transaction transaction = new Transaction(
                    account.get_id(),
                    faker.finance().iban("DK"),
                    faker.date().between(Date.from(account.getDate_opened().atStartOfDay(ZoneId.systemDefault()).toInstant()), date).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    faker.number().randomDouble(2, 0, 6500)
                );

                transactionRepository.save(transaction);

            }

        };
    }
}
