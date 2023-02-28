package tech.kennet.bankingsql.account;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping(path = "{accountId}")
    public Optional<Account> getAccount(@PathVariable("accountId") Long accountId) {
        return accountService.getAccountById(accountId);
    }
    
    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}") 
    public void deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @PutMapping(path = "{accountId}")
    public void updateAccount(@PathVariable("accountId") Long accountId, @RequestParam(required = false) String name, @RequestParam(required = true) Double ballance, @RequestParam(required = false) LocalDate accountOpened, @RequestParam(required = false) Long accountType ) {
        accountService.updateAccount(accountId, name, ballance, accountOpened, accountType);
    }
}
