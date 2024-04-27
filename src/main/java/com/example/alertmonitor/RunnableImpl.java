package com.example.alertmonitor;

import com.example.alertmonitor.model.*;
import com.example.alertmonitor.service.MonitoringService;

import java.util.List;

public class RunnableImpl implements Runnable {

    MonitoringService monitoringService = new MonitoringService();

    @Override
    public void run() {
        // test alerts to fire
        List<Alert> alerts = List.of(
                new Alert("X", "PAYMENT_EXCEPTION", new AlertConfig(ConfigType.TUMBLING_WINDOW, 3, 10),
                        List.of(new DispatchStrategy(DispatchType.CONSOLE, "issue in payment"),
                                new DispatchStrategy(DispatchType.EMAIL, "payment exception threshold breached"))),
                new Alert("Y", "USER_SERVICE_EXCEPTION", new AlertConfig(ConfigType.SIMPLE_COUNT, 3, 0),
                        List.of(new DispatchStrategy(DispatchType.CONSOLE, "issue in user service"))));
        monitoringService.fireAlert(alerts);
    }
}
