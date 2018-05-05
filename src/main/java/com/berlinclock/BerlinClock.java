package com.berlinclock;

import java.util.Arrays;
import java.util.Collections;


public class BerlinClock {

    private static final String LINE = System.getProperty("line.separator");
    private static final String NTP = "No time provided";
    private static final String ITP = "Invalid time provided.";
    private static final String CHECK_TIME = "Time values must be numeric.";

    public BerlinClock(String value) {

        if(value == null) {
            throw new IllegalArgumentException(NTP);
        }

        String[] times = value.split(":", 3);

        if(times.length != 3) {
            throw new IllegalArgumentException(ITP);
        }

        int hours, minutes, seconds = 0;
        
        try {
            hours = Integer.parseInt(times[0]);
            minutes = Integer.parseInt(times[1]);
            seconds = Integer.parseInt(times[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHECK_TIME);
        }
        if (hours < 0 || hours > 23) throw new IllegalArgumentException("Invalid hours.");
        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("Invalid minutes.");
        if (seconds < 0 || seconds > 59) throw new IllegalArgumentException("Invalid Seconds.");
        processTime(hours, minutes, seconds);
    }

    private String processTime(int hours, int minutes, int seconds) {
        String l1 = (seconds % 2 == 0) ? "Y" : "0";
        String l2 = formatData(hours / 5, 4, "R");
        String l3 = formatData(hours % 5, 4, "R");
        String l4 = formatData(minutes / 5, 11, "Y").replaceAll("YYY", "YYR");
        String l5 = formatData(minutes % 5, 4, "Y");
        return String.join(LINE, Arrays.asList(l1, l2, l3, l4, l5));
    }

    private String formatData(int openLight, int noOfLightInRow, String typeOFLamp) {
        int cloasedLight = noOfLightInRow - openLight;
        String lit = String.join("", Collections.nCopies(openLight, typeOFLamp));
        String unlit = String.join("", Collections.nCopies(cloasedLight, "0"));
        return lit + unlit;
    }
}
