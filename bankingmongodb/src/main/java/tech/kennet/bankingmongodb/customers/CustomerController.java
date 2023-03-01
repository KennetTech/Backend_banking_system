package tech.kennet.bankingmongodb.customers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("api/v2/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> fetchAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Optional<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String customerid) {
        customerService.deleteCustomer(customerid);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") String customerId, @RequestParam(required = false) String first_name, @RequestParam(required = false) String last_name, @RequestParam(required = false) String email, @RequestParam(required = false) LocalDate date_of_birth, @RequestParam(required = false) String customertype_id, @RequestParam(required = false) String branch_id) {
        customerService.updateCustomer(customerId, first_name, last_name, email, date_of_birth, customertype_id, branch_id);
    }
}
