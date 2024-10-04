package com.example.card_app.controller;

import com.example.card_app.model.Customer;
import com.example.card_app.repository.CustomerRepository;

import jakarta.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
public ResponseEntity<List<Customer>> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    
    if (customers.isEmpty()) {
        return ResponseEntity.noContent().build(); // 204 pas de contenu
    }
    
    return ResponseEntity.ok(customers); // 200 OK avec liste Customer
}


    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    
    
    @Id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
    // Utilisation du repository pour récupérer un Customer par ID
    return customerRepository.findById(id)
            .map(customer -> ResponseEntity.ok().body(customer))
            .orElse(ResponseEntity.notFound().build());
}

/*@DeleteMapping("/deleteCustomerById/{customerId}")
public ResponseEntity<?> deleteCustomerById(@PathVariable int customerId) {
    return customerRepository.findById(customerId)
        .map(customer -> {
            customerRepository.delete(customer);
            return ResponseEntity.ok().body(customerId);
        })
        .orElse(ResponseEntity.notFound().build());
}*/

}









