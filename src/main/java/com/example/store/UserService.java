package com.example.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationUService notificationUService;

    public UserService(UserRepository userRepository, NotificationUService notificationUService) {
        this.userRepository = userRepository;
        this.notificationUService = notificationUService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
        notificationUService.send("You registered successfully",user.getEmail());
    }

}
