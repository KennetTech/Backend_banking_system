package tech.kennet.bankingsql.customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
        System.out.println(customer);
    }

    public void deleteCustomer(Long customerid) {
        Boolean exists = customerRepository.existsById(customerid);
        if (!exists) {
            throw new IllegalStateException("student with id " + customerid + " does not exists");
        }
        customerRepository.deleteById(customerid);
    }

    public void updateCustomer(Long customerId, String name, String email) {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new IllegalStateException(
            "customer with id " + customerId + " does not exists"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }
    }
}
