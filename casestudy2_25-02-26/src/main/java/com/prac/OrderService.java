package com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final NotificationService notificationService;

    @Autowired
    private RestaurantService restaurantService;

    public OrderService(@Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        notificationService.sendNotification("Order placed successfully");
    }
}