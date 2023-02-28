package tech.kennet.bankingsql.account;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public void addNewAccount(Account account) {
    }

    public void deleteAccount(Long accountId) {
    }

    public void updateAccount(Long accountId, String name, Double ballance, LocalDate accountOpened, Long accountType) {
        Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new IllegalStateException(
            "Account with id " + accountId + " does not exists"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(account.getName(), name)) {
            account.setName(name);
        }

        if (true) {
            account.setBallance(ballance);
        }

        if (accountOpened != null && !Objects.equals(account.getAccountOpened(), accountOpened)) {
            account.setAccountOpened(accountOpened);            
        }

        if (accountType != null && !Objects.equals(account.getAccountType(), accountType)) {
            account.setAccountType(accountType);
        }

        accountRepository.save(account);
    }
    
}
