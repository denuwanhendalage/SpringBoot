package com.example.store;

import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    // final is used to prevent accidentally overwrite issues
    private final NotificationService notificationService;

    public NotificationManager(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    public void sendNotification(String message){
        notificationService.send(message);
    }
}
