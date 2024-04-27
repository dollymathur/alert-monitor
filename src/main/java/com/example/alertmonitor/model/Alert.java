package com.example.alertmonitor.model;

import java.util.List;

public class Alert {
    String client;
    String eventType;
    AlertConfig alertConfig;
    List<DispatchStrategy> dispatchStrategies;

    public Alert(String client, String eventType, AlertConfig alertConfig, List<DispatchStrategy> dispatchStrategies) {
        this.client = client;
        this.eventType = eventType;
        this.alertConfig = alertConfig;
        this.dispatchStrategies = dispatchStrategies;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public AlertConfig getAlertConfig() {
        return alertConfig;
    }

    public void setAlertConfig(AlertConfig alertConfig) {
        this.alertConfig = alertConfig;
    }

    public List<DispatchStrategy> getDispatchStrategies() {
        return dispatchStrategies;
    }

    public void setDispatchStrategies(List<DispatchStrategy> dispatchStrategies) {
        this.dispatchStrategies = dispatchStrategies;
    }
}
