package com.example.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    // in this class can contain one or more method to creating beans
    // stripe is the name which is assigned to bean
    @Value("${payment.stripe}")
    private boolean isStripe;

    @Bean // using @Bean we tell it is bean producer
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PayPalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        if (isStripe){
            return new OrderService(stripe());
        }else {
            return new OrderService(paypal());
        }

    }
}
