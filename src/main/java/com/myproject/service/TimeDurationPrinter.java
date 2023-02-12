package com.myproject.service;

import java.time.Duration;

public class TimeDurationPrinter {
    public static String printTimeDuration(Duration duration) {
        return String.format("%d:%02d.%03d",
                duration.toMinutesPart(),
                duration.toSecondsPart(),
                duration.toMillisPart());
    }
}
