package com.example.alertmonitor.model;

public class AlertConfig {
    ConfigType configType;
    int count;
    int windowSizeInSecs;

    public AlertConfig(ConfigType configType, int count, int windowSizeInSecs) {
        this.configType = configType;
        this.count = count;
        this.windowSizeInSecs = windowSizeInSecs;
    }

    public ConfigType getConfigType() {
        return configType;
    }

    public void setConfigType(ConfigType configType) {
        this.configType = configType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWindowSizeInSecs() {
        return windowSizeInSecs;
    }

    public void setWindowSizeInSecs(int windowSizeInSecs) {
        this.windowSizeInSecs = windowSizeInSecs;
    }
}
