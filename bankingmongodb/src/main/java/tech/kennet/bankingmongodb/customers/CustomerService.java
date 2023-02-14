package tech.kennet.bankingmongodb.customers;

import java.time.LocalDate;
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

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.findCustomerByEmail(customer.getEmail()).ifPresentOrElse(c -> {
            System.out.println(c + " already exists");
        }, ()-> {
            System.out.println("inserting customer " + customer);
            customerRepository.save(customer);
        });
        
    }

    public void deleteCustomer(String customerid) {
        if (!customerRepository.existsById(customerid)) {
            throw new IllegalStateException(
                "customer with id " + customerid + " does not exists"
            );
        }
        customerRepository.deleteById(customerid);
    }

    public void updateCustomer(String customerId, String first_name, String last_name, String email, LocalDate date_of_birth, String customertype_id, String branch_id) {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new IllegalStateException(
            "customer with id " + customerId + " does not exists"
        ));

        if (first_name != null && first_name.length() > 0 && !Objects.equals(customer.getFirst_name(), first_name)) {
            customer.setFirst_name(first_name);
        }

        if (last_name != null && last_name.length() > 0 && !Objects.equals(customer.getLast_name(), last_name)) {
            customer.setLast_name(last_name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }

        if (date_of_birth != null && !Objects.equals(customer.getDate_of_birth(), date_of_birth)) {
            customer.setDate_of_birth(date_of_birth);
        }

        if (customertype_id != null && customertype_id.length() > 0 && !Objects.equals(customer.getCustomertype_id(), customertype_id)) {
            customer.setCustomertype_id(customertype_id);
        }

        if (branch_id != null && branch_id.length() > 0 && !Objects.equals(customer.getBranch_id(), branch_id)) {
            customer.setBranch_id(branch_id);
        }
    }
}
