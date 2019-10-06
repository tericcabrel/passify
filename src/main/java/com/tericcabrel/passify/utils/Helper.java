package com.tericcabrel.passify.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * @author zegeek
 */
public class Helper {
    /**
     * @param min Minimum range value
     * @param max Maximum range value
     *
     * @return int
     */
    public static int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();

        // new Random().nextInt(5);  => [0...4]
        // new Random().nextInt(5 + 1);  => [0...5]
        // new Random().nextInt(10 - 5 + 1) + 5;  // [0...5] + 5 => [5...10]
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * @param dateString Date in string to parse
     *
     * @return Date|null
     */
    @org.jetbrains.annotations.Nullable
    public static Date formatSQLToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
