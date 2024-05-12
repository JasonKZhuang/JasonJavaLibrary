/**
 * Project: JasonJavaLibrary
 * Date: 27/8/2022
 * Author: Jason
 * Reference:https://www.baeldung.com/java-8-date-time-intro
 */
package com.jasonz.java8Features.datetimeAPI;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateAndTimeFormatting {

    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        //This code passes an ISO date format to format the local date, with a result of 2015-01-25:
        String localDateString1 = localDateTime1.format(DateTimeFormatter.ISO_DATE);
        System.out.println(localDateString1);

        //Custom patterns can be provided to the format method as well, which here returns a LocalDate as 2015/01/25:
        LocalDateTime localDateTime2 = LocalDateTime.now();
        String localDateString2 = "" ;
        localDateString2=       localDateTime2.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
        System.out.println(localDateString2);

        localDateString2=       localDateTime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(localDateString2);

        //We can pass in formatting style either as SHORT, LONG or MEDIUM as part of the formatting option
        LocalDateTime localDateTime3 = LocalDateTime.now();
        String localDateString3 = "";

//        localDateString3 = localDateTime3.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.UK));
//        System.out.println(localDateString3);


        localDateString3 = localDateTime3.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.ENGLISH));
        System.out.println(localDateString3);

        localDateString3 = localDateTime3.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.SIMPLIFIED_CHINESE));
        System.out.println(localDateString3);



    }
}
