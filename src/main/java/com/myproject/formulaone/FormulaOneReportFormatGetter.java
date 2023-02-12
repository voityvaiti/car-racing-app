package com.myproject.formulaone;

import com.myproject.model.Racer;

import java.util.Comparator;
import java.util.Map;

public class FormulaOneReportFormatGetter {

    private static final int NUMBER_COLUMN_WIDTH = 4;
    private final int NAME_COLUMN_WIDTH;
    private final int CAR_COLUMN_WIDTH;
    private static final int TIME_COLUMN_WIDTH = 8;

    public FormulaOneReportFormatGetter(Map<String, Racer> racerAbbreviationsToRacers) {
        this.NAME_COLUMN_WIDTH = getMaxRacerNameLength(racerAbbreviationsToRacers);
        this.CAR_COLUMN_WIDTH = getMaxRacerCarLength(racerAbbreviationsToRacers);
    }

    public String getReportFormat() {
        return "%-" +
                NUMBER_COLUMN_WIDTH +
                "s%-" +
                NAME_COLUMN_WIDTH +
                "s  | %-" +
                CAR_COLUMN_WIDTH +
                "s  | %-" +
                TIME_COLUMN_WIDTH +
                "s";
    }

    public int getReportWidth() {
        final int VERTICAL_LINES_AMOUNT = 2;
        final int ADDITIONAL_SPACES_AMOUNT = 6;

        return NUMBER_COLUMN_WIDTH + NAME_COLUMN_WIDTH + CAR_COLUMN_WIDTH + TIME_COLUMN_WIDTH +
                VERTICAL_LINES_AMOUNT + ADDITIONAL_SPACES_AMOUNT;
    }

    private int getMaxRacerNameLength(Map<String, Racer> map) {
        if (map.isEmpty()) {
            return 0;
        }
        return map.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().getName().length()))
                .get().getValue().getName().length();
    }

    private int getMaxRacerCarLength(Map<String, Racer> map) {
        if (map.isEmpty()) {
            return 0;
        }
        return map.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().getCar().length()))
                .get().getValue().getCar().length();
    }
}
