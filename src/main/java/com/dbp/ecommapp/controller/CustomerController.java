package com.dbp.ecommapp.controller;


import com.dbp.ecommapp.entity.Customer;
import com.dbp.ecommapp.exception.ResourceNotFoundException;
import com.dbp.ecommapp.repository.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/customers")
public class CustomerController {



    @Autowired
    private CustomerRepository customerRepository ;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();





    /**
     * List all customers.
     *
     * @param  customer model
     * @return
     */
    
    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    /**
     * Find a specific customer by its id.
     *
     * @param customerId
     * @param  throw error
     * @return
     */
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getEmployeeById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }


    /**
     * New customer.
     *
     * @param customer model
     * @return
     */
    
    @PostMapping("/")
    public Customer createCoustmer(@Valid @RequestBody Customer customer) {

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }


    /**
     * Generate Fake customer.
     *
     * @param faker
     * @return
     */
    
    @PostMapping("/fake")
    public Customer createCustomer2() {
        Faker faker = new Faker();
        Customer customer = new Customer();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setCustomerEmail(faker.bothify(faker.funnyName().name().replaceAll("\\s+","").toLowerCase()+"@gmail.com"));
        customer.setCustomerMobile(faker.bothify("9665########"));
        customer.setCity(faker.address().city());
        customer.setAddress(faker.address().fullAddress());
        customer.setPassword(passwordEncoder.encode("123456789"));
        return customerRepository.save(customer);
    }


    /**
     * Delete customer by its id.
     *
     * @param customerId
     * @return
     */
    
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
