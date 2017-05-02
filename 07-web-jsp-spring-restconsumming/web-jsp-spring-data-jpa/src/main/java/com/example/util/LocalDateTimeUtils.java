package com.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by RENT on 2017-03-07.
 */
public class LocalDateTimeUtils {
    public static String formatLocalDate(LocalDateTime localDateTime, String pattern){
        if (localDateTime == null) return "";
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
