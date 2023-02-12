package com.myproject.formulaone.timehandlers;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SorterByTime {
    public List<String> getAbbreviateRacersSortedByTime(Map<String, Duration> racersToTime) {
        return racersToTime.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();
    }
}
