package com.myproject.filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeFileReader {

    final static String DATE_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSS";

    public Map<String, Date> readEndTime() {
        return read("end");
    }

    public Map<String, Date> readStartTime() {
        return read("start");
    }

    private Map<String, Date> read(String time) {

        try (FileInputStream abbreviationsFileStream =
                     new FileInputStream("src/main/resources/" + time + ".log")) {

            BufferedReader abbreviationsBufferedReader =
                    new BufferedReader(new InputStreamReader(abbreviationsFileStream));

            Map<String, Date> abbreviationToTime = new HashMap<>();
            String line;

            DateFormat dateTimeFormat = new SimpleDateFormat(DATE_FORMAT);

            while ((line = abbreviationsBufferedReader.readLine()) != null) {
                String abbreviation = line.substring(0, 3);
                line = line.replace(abbreviation, "");

                abbreviationToTime.put(abbreviation, dateTimeFormat.parse(line));
            }

            return abbreviationToTime;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }
}
