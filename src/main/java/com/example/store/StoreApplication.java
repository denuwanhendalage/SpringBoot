package com.example.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L,"mosh","mosh@codewithmosh.com","12345"));
        userService.registerUser(new User(1L,"mosh","mosh@codewithmosh.com","12345"));


    }

}
