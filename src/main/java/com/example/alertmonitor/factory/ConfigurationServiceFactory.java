package com.example.alertmonitor.factory;

import com.example.alertmonitor.model.Alert;
import com.example.alertmonitor.model.ConfigType;
import com.example.alertmonitor.model.DispatchStrategy;
import com.example.alertmonitor.service.alertconfiguration.AlertConfigurationService;
import com.example.alertmonitor.service.alertconfiguration.SimpleCountConfigurationService;
import com.example.alertmonitor.service.alertconfiguration.SlidingWindowConfigurationService;
import com.example.alertmonitor.service.alertconfiguration.TumblingWindowConfigurationService;
import com.example.alertmonitor.service.dispatcher.DispatcherService;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationServiceFactory {

    DispatcherServiceFactory dispatcherServiceFactory;

    public ConfigurationServiceFactory(DispatcherServiceFactory dispatcherServiceFactory) {
        this.dispatcherServiceFactory = dispatcherServiceFactory;
    }

    public static AlertConfigurationService getConfigurationService(Alert alert) {

        List<DispatcherService> dispatcherServices = getDispatcherServices(alert);

        return switch (alert.getAlertConfig().getConfigType()) {
            case SIMPLE_COUNT -> new SimpleCountConfigurationService(dispatcherServices, alert.getAlertConfig());
            case TUMBLING_WINDOW -> new TumblingWindowConfigurationService(dispatcherServices, alert.getAlertConfig());
            case SLIDING_WINDOW -> new SlidingWindowConfigurationService(dispatcherServices, alert.getAlertConfig());
            default -> null;
        };
    }

    private static List<DispatcherService> getDispatcherServices(Alert alert) {
        List<DispatcherService> dispatcherServices = new ArrayList<>();
        for (DispatchStrategy dispatchStrategy : alert.getDispatchStrategies()) {
            DispatcherService dispatcherService = DispatcherServiceFactory.getDispatcherService(dispatchStrategy);
            if (dispatcherService != null) {
                dispatcherServices.add(dispatcherService);
            }
        }
        return dispatcherServices;
    }
}
