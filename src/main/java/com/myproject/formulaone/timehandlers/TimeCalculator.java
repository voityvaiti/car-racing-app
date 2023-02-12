package com.myproject.formulaone.timehandlers;

import com.myproject.filereader.TimeFileReader;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeCalculator {
    public Map<String, Duration> getCalculatedTime() {

        Map<String, Duration> racersToTime = new HashMap<>();

        TimeFileReader timeFileReader = new TimeFileReader();
        Map<String, Date> racersToStartTime = timeFileReader.readStartTime();
        Map<String, Date> racersToEndTime = timeFileReader.readEndTime();


        try {
            for (Map.Entry<String, Date> racerToEndTime : racersToEndTime.entrySet()) {

                String racerAbbreviation = racerToEndTime.getKey();

                Date racerStartTime = racersToStartTime.get(racerAbbreviation);
                Date racerEndTime = racerToEndTime.getValue();

                Duration racerTime = Duration.ofMillis(
                        racerEndTime.getTime() - racerStartTime.getTime()
                );

                racersToTime.put(racerAbbreviation, racerTime);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return racersToTime;
    }
}
