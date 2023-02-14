package tech.kennet.bankingmongodb.accounts;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tech.kennet.bankingmongodb.customers.CustomerRepository;


@AllArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void addNewAccount(Account account) {
        
            accountRepository.save(account);
        }

    public void deleteAccount(String accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new IllegalStateException(
                "account with id " + accountId + " does not exists"
            );
        }
        accountRepository.deleteById(accountId);
        
    }

    public void updateAccount(String accountId, String account_name, Double balance, LocalDate date_opened,
            String owner_Id) {

            Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalStateException(
            "account with id " + accountId + " does not exists"
        ));

        if (account_name != null && account_name.length() > 0 && !Objects.equals(account.getAccount_name(), account_name)) {
            account.setAccount_name(account_name);
        }

        if (balance != null) {
            account.setBalance(balance);
        }

        if (date_opened != null) {
            account.setDate_opened(date_opened);
        }

        if(owner_Id != null) {
            account.getOwner_id().add(owner_Id);
        }
    }

    public void updateCustomerAccount(String accountId, String ownerId) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalStateException(
            "account with id " + accountId + " does not exists"
        ));
        
        Boolean exists = customerRepository.existsById(ownerId);

        if (!exists) {
            throw new IllegalStateException("customer with id " + ownerId + " does not exists");
        }

        account.getOwner_id().add(ownerId);
        accountRepository.save(account);

        

    }

    

    
    
}
