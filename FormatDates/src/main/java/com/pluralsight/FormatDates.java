package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FormatDates {       // Appname
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        dateFormat1(now);
        dateFormat2(now);
        System.out.println(getFormat3(now));
        dateFormat4(now); //now
        dateFormat5(now);
        dateFormat6(now);
    }

    private static boolean getLongMonthFormat3(LocalDateTime now) {
        return true;
    }

    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        System.out.println(now.format(format1));
    }

    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");// P
        System.out.println(now.format(format2));
    }

    static String getFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return format3.format(now);//changed to format 3 no need to print

    }

    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("eeee, MMM d, yyyy");
        System.out.println(time.format(format4));
    }

    static void dateFormat5(LocalDateTime now) {
        ZonedDateTime gmtTime = now.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT"));
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm"); //t
        System.out.println(gmtTime.format(format5) + " \u00DF display in GMT time"); //+=
    }


    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + " \u00DF display in your local time zone");
    }
}
