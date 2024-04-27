package com.example.alertmonitor.service;

import com.example.alertmonitor.factory.ConfigurationServiceFactory;
import com.example.alertmonitor.model.Alert;
import com.example.alertmonitor.service.alertconfiguration.AlertConfigurationService;

import java.util.List;

public class MonitoringService {

    public void fireAlert(List<Alert> alerts) {
        for (Alert alert : alerts) {
            System.out.println("Client " + alert.getClient() + " firing event " + alert.getEventType());
            AlertConfigurationService alertConfigurationService = ConfigurationServiceFactory.getConfigurationService(alert);
            if (alertConfigurationService != null) {
                alertConfigurationService.fireAlert();
            }
            else {
                System.out.println("No configuration service found for alert " + alert.getEventType() + " for client " + alert.getClient());
            }
            System.out.println();
        }

    }
}
