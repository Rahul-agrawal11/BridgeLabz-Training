package com.junit;

public class PerformanceTask {

    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("Task interrupted due to timeout");
        }
        return "hello";
    }
}
