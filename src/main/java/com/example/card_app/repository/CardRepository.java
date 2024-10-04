package com.example.card_app.repository;

import com.example.card_app.model.Card;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CardRepository extends JpaRepository<Card, Integer> {

    // Add @Transactional annotation to support modifying queries
    @Transactional
    @Modifying
    @Query("DELETE FROM Card c WHERE c.customer.customerId = ?1")
    void deleteCardsByCustomerId(int customerId);

    Card findByCardNumber(String cardNumber);

    // Uncommented this to check existence of card by card number
    // boolean existsByCardNumber(String cardNumber); // Typo correction: 'exist' -> 'exists'

    // Corrected method to properly map customerId field in Card's customer object
    List<Card> findByCustomer_CustomerId(int customerId);

    // Correctly delete all by cardId (primary key field)
    void deleteAllByCardIdIn(List<Integer> cardIds);

    // Removed unnecessary method 'deleteAllByIdIn' since 'deleteAllByCardIdIn' is sufficient
    // void deleteAllByIdIn(List<Integer> ids); 

}





/* 


package com.example.card_app.repository;


import com.example.card_app.model.Card;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

*/


/* 
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Modifying
    @Query("DELETE Card c WHERE c.customer.id= ?1")
    void deleteCardsByCustomerId(int customerId);

   Card findByCardNumber(String cardNumber);

   //boolean existByCardNumber(String cardNumber);

   List <Card> findByCustomerId(int customerId);
   void deleteAllByCardIdIn(List<Integer> cardIds);
   List<Card> findByCustomer_CustomerId(int customerId);



void deleteAllByIdIn(List<Integer> ids);





}*/