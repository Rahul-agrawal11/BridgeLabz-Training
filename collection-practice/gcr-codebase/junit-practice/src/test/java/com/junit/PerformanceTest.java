package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {

    PerformanceTask p = new PerformanceTask();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTask() {
        assertEquals("hello", p.longRunningTask());
    }
}
