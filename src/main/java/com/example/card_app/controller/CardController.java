package com.example.card_app.controller;

import com.example.card_app.model.Card;
import com.example.card_app.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    // Retrieve all cards
    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 pas de Contenu
        }
        return ResponseEntity.ok(cards); // Return 200 OK avec la liste cards
    }

    // Add a new card
    @PostMapping("/add")
    public Card addCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    // Retrieve card by ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        // Utilisation du repository pour récupérer une carte par ID
        return cardRepository.findById(id)
                .map(card -> ResponseEntity.ok().body(card))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete card by card number
    @DeleteMapping("/deleteCardByNumber/{cardNumber}")
    public ResponseEntity<?> deleteCardByNumber(@PathVariable String cardNumber) {
        // Modifié : Vérification si la carte existe en cherchant par cardNumber
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card != null) {
            cardRepository.delete(card);
            return ResponseEntity.ok().build(); // 200 OK sur suppression réussie
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si la carte n'existe pas
        }

        // Ancien code :
        /*
         * @DeleteMapping("/deleteCardByNumber/{cardNumber}")
         * public ResponseEntity<?> deleteCardByNumber(@PathVariable String cardNumber) {
         *     // cardRepository.existByCardNumber(cardNumber)
         *     if (true) {
         *         Card card = cardRepository.findByCardNumber(cardNumber);
         *         cardRepository.delete(card);
         *         return ResponseEntity.ok().build();
         *     } else {
         *         return ResponseEntity.notFound().build();
         *     }
         * }
         */
    }

    /*
     * @DeleteMapping("/deleteCardsByCustomerId/{customerId}")
     * public ResponseEntity<?> deleteCardsByCustomerId(@PathVariable int customerId) {
     * List<Card> cards = cardRepository.findByCustomerId(customerId);
     * 
     * if (cards != null && !cards.isEmpty()) {
     * cardRepository.deleteAll(cards);
     * return ResponseEntity.ok().build();
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     */
}
