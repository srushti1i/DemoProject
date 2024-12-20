package com.nits.util;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String DateTime() {
        // Removed the static keyword from the local variable
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");

        String output = FORMATTER.format(LocalDateTime.now());
        return output;
    }
}
