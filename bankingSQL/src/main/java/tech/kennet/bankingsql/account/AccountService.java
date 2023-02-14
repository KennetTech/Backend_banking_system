package tech.kennet.bankingsql.account;

import java.time.LocalDate;
import java.util.List;
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

    public Optional<Account> getAccountById() {
        return null;
    }

    public void addNewAccount(Account account) {
    }

    public void deleteAccount(Long accountId) {
    }

    public void updateAccount(Long accountId, String name, double ballance, LocalDate accountOpened, Long accountType) {
    }
    
}
