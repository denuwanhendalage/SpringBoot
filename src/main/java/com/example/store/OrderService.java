package com.example.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
    private PaymentService paymentService;

//    @Autowired
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    @PostConstruct
    public void init(){
        System.out.println("OrderService postConstruct");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("OrderService PreDestroy");
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
