package com.example.alertmonitor.service.dispatcher;

import java.time.Instant;

public class ConsoleDispatcherService implements DispatcherService {

    String message;

    public ConsoleDispatcherService(String message) {
        this.message = message;
    }

    @Override
    public void dispatchAlert() {
        System.out.println("Dispatching alert on console: " + message);
    }
}
