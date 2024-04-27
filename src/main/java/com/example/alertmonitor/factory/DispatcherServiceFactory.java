package com.example.alertmonitor.factory;

import com.example.alertmonitor.model.DispatchStrategy;
import com.example.alertmonitor.model.DispatchType;
import com.example.alertmonitor.service.dispatcher.ConsoleDispatcherService;
import com.example.alertmonitor.service.dispatcher.DispatcherService;
import com.example.alertmonitor.service.dispatcher.EmailDispatcherService;
import com.example.alertmonitor.service.dispatcher.SmsDispatcherService;

public class DispatcherServiceFactory {

    public static DispatcherService getDispatcherService(DispatchStrategy dispatchStrategy) {
        return switch (dispatchStrategy.getDispatchType()) {
            case EMAIL -> new EmailDispatcherService(dispatchStrategy.getMessage());
            case SMS -> new SmsDispatcherService(dispatchStrategy.getMessage());
            case CONSOLE -> new ConsoleDispatcherService(dispatchStrategy.getMessage());
            default -> null;
        };
    }

}
