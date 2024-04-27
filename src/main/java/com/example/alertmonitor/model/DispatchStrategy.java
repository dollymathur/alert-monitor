package com.example.alertmonitor.model;

public class DispatchStrategy {
    DispatchType dispatchType;
    String message;

    public DispatchStrategy(DispatchType dispatchType, String message) {
        this.dispatchType = dispatchType;
        this.message = message;
    }

    public DispatchType getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(DispatchType dispatchType) {
        this.dispatchType = dispatchType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
