package com.myproject.filereader;

import com.myproject.model.Racer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AbbreviationsFileReader {

    private final static int ABBREVIATION_INDEX = 0;
    private final static int RACER_NAME_INDEX = 1;
    private final static int RACER_CAR_INDEX = 2;

    public Map<String, Racer> read() {

        try (FileInputStream abbreviationsFileStream =
                     new FileInputStream("src/main/resources/abbreviations.txt")) {

            BufferedReader abbreviationsBufferedReader =
                    new BufferedReader(new InputStreamReader(abbreviationsFileStream));

            Map<String, Racer> abbreviationToRacer = new HashMap<>();
            String line;

            while ((line = abbreviationsBufferedReader.readLine()) != null) {

                String[] lineElements = line.split("_");

                abbreviationToRacer.put(lineElements[ABBREVIATION_INDEX],
                        new Racer(lineElements[RACER_NAME_INDEX], lineElements[RACER_CAR_INDEX]));

            }
            return abbreviationToRacer;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }
}