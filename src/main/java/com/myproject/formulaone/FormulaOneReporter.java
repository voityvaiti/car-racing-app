package com.myproject.formulaone;

import com.myproject.filereader.AbbreviationsFileReader;
import com.myproject.formulaone.timehandlers.TimeCalculator;
import com.myproject.formulaone.timehandlers.SorterByTime;
import com.myproject.model.Racer;
import com.myproject.service.TimeDurationPrinter;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class FormulaOneReporter {
    public String getReport() {

        StringBuilder reportBuilder = new StringBuilder();

        Map<String, Racer> racerAbbreviationsToRacers = new AbbreviationsFileReader().read();
        Map<String, Duration> racerAbbreviationsToTime = new TimeCalculator().getCalculatedTime();
        List<String> racerAbbreviationsSortedByTime = new SorterByTime().getAbbreviateRacersSortedByTime(
                racerAbbreviationsToTime
        );

        FormulaOneReportFormatGetter reportFormatGetter = new FormulaOneReportFormatGetter(racerAbbreviationsToRacers);

        int racerNumber = 1;
        final int LAST_TOP_RACER = 15;

        final String HORIZONTAL_LINE = "-";
        final String NEWLINE = "\n";

        for (String racerAbbreviation : racerAbbreviationsSortedByTime) {
            Racer racer = racerAbbreviationsToRacers.get(racerAbbreviation);

            String line = String.format(reportFormatGetter.getReportFormat(),
                    racerNumber + ".",
                    racer.getName(),
                    racer.getCar(),
                    TimeDurationPrinter.printTimeDuration(
                            racerAbbreviationsToTime.get(racerAbbreviation))
            );
            reportBuilder.append(line).append(NEWLINE);

            if (racerNumber == LAST_TOP_RACER) {
                reportBuilder.append(HORIZONTAL_LINE.repeat(reportFormatGetter.getReportWidth())).
                        append(NEWLINE);
            }

            racerNumber++;
        }

        return reportBuilder.toString();
    }
}