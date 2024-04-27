package com.example.alertmonitor;

public class AlertMonitorApplication {

    public static void main(String[] args) {

        // Spinning up anew thread.
        Thread t1 = new Thread(new RunnableImpl());
        t1.start();

        /*Thread t2 = new Thread(new RunnableImpl());
        t2.start();*/

    }
}
