package com.example.card_app.repository;


import com.example.card_app.model.Card;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Integer> {

    @Modifying
    @Query("DELETE Card c WHERE c.customer.id= ?1")
    void deleteCardsByCustomerId(int customerId);

   Card findByCardNumber(String cardNumber);

   //boolean existByCardNumber(String cardNumber);

   List <Card> findByCustomerId(int customerId);

void deleteAllByIdIn(List<Integer> ids);





}