package com.myproject.formulaone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormulaOneReporterTest {
    static FormulaOneReporter formulaOneReporter = new FormulaOneReporter();

    @Test
    void getReport_returnCorrectReport_ifRequiredFilesIsPresent() {

        String expected = """
                1.  Charles Leclerc    | SAUBER FERRARI             | 0:31.829
                2.  Kimi Raikkonen     | FERRARI                    | 0:42.639
                3.  Stoffel Vandoorne  | MCLAREN RENAULT            | 0:45.463
                4.  Marcus Ericsson    | SAUBER FERRARI             | 0:53.265
                5.  Sergey Sirotkin    | WILLIAMS MERCEDES          | 0:55.706
                6.  Lance Stroll       | WILLIAMS MERCEDES          | 1:00.323
                7.  Carlos Sainz       | RENAULT                    | 1:06.950
                8.  Fernando Alonso    | MCLAREN RENAULT            | 1:09.657
                9.  Pierre Gasly       | SCUDERIA TORO ROSSO HONDA  | 1:10.941
                10. Nico Hulkenberg    | RENAULT                    | 1:20.065
                11. Romain Grosjean    | HAAS FERRARI               | 1:28.930
                12. Lewis Hamilton     | MERCEDES                   | 1:32.460
                13. Sergio Perez       | FORCE INDIA MERCEDES       | 1:40.848
                14. Valtteri Bottas    | MERCEDES                   | 1:42.434
                15. Daniel Ricciardo   | RED BULL RACING TAG HEUER  | 1:47.013
                --------------------------------------------------------------
                16. Esteban Ocon       | FORCE INDIA MERCEDES       | 1:54.028
                17. Kevin Magnussen    | HAAS FERRARI               | 1:57.393
                18. Sebastian Vettel   | FERRARI                    | 1:59.415
                19. Brendon Hartley    | SCUDERIA TORO ROSSO HONDA  | 2:53.179
                                """;

        assertEquals(expected, formulaOneReporter.getReport());
    }
}