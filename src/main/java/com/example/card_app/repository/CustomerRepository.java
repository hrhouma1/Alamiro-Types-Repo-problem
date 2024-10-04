package com.example.card_app.repository;

import com.example.card_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   
   // Corrected method to return Customer and expect customerId of type Integer
   Customer findByCustomerId(Integer customerId);
}


/*package com.example.card_app.repository;


    
import com.example.card_app.model.Card;
import com.example.card_app.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   Card findByCustomerId(String customerId);
}
*/
