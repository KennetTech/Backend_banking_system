package tech.kennet.bankingmongodb.accounts;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> fetchAllAccounts() {
        return accountService.getAllAccounts();
    }
    
    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") String accountId) {
        accountService.deleteAccount(accountId);
    }
    
    @PutMapping(path = "{accountId}")
    public void updateCustomer(@PathVariable("accountId") String accountId, @RequestParam(required = false) String account_name, @RequestParam(required = false) Double balance , @RequestParam(required = false) LocalDate date_opened, @RequestParam(required = false) String owner_Id) {
        accountService.updateAccount(accountId, account_name, balance, date_opened, owner_Id);
    }

    @PutMapping(path = "/{accountId}/addaccount/{customerId}")
    public void updateCustomerAccount(@PathVariable Map<String, String> pathVarsMap) {
        accountService.updateCustomerAccount(pathVarsMap.get("accountId"), pathVarsMap.get("customerId"));
    }
}
