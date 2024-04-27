package com.example.alertmonitor.service.dispatcher;

import java.time.Instant;

public class SmsDispatcherService implements DispatcherService {

    String message;

    public SmsDispatcherService(String message) {
        this.message = message;
    }

    @Override
    public void dispatchAlert() {
        System.out.println("Dispatching alert on sms: " + message);
    }
}
