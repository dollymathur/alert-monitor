package com.example.alertmonitor.service.alertconfiguration;

import com.example.alertmonitor.model.AlertConfig;
import com.example.alertmonitor.service.dispatcher.DispatcherService;

import java.util.List;

public class TumblingWindowConfigurationService implements AlertConfigurationService {

    List<DispatcherService> dispatcherServices;
    AlertConfig alertConfig;

    public TumblingWindowConfigurationService(List<DispatcherService> dispatcherServices, AlertConfig alertConfig) {
        this.dispatcherServices = dispatcherServices;
        this.alertConfig = alertConfig;
    }

    @Override
    public void fireAlert() {
        try {
            for (int i = 1; i <= alertConfig.getCount(); i++) {
                // for each type of dispatcher service, dispatch the alert
                dispatcherServices.forEach(DispatcherService::dispatchAlert);
                Thread.sleep(alertConfig.getWindowSizeInSecs());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
