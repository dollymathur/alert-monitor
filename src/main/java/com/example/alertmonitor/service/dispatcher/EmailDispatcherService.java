package com.example.alertmonitor.service.dispatcher;

import java.time.Instant;

public class EmailDispatcherService implements DispatcherService {

    String message;

    public EmailDispatcherService(String message) {
        this.message = message;
    }

    @Override
    public void dispatchAlert() {
        System.out.println("Dispatching alert on email: " + message);
    }
}
