package com.example.card_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    // Constructeurs

    public Customer() {
    }

    public Customer(String customerLastName, String customerFirstName) {
        this.customerLastName = customerLastName;
        this.customerFirstName = customerFirstName;
    }

    // Getters et Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
}