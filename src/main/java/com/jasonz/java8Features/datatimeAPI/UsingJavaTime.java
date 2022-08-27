package com.jasonz.java8Features.datatimeAPI;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Reference:https://www.tutorialspoint.com/java8/java8_datetime_api.htm
 *
 * @author Jason Zhuang 23 Jun. 2021
 */
public class UsingJavaTime {
    //		We can create DateTimeFormatter in three ways:
    //		Using inbuilt patterns
    //		Using custom patterns using ofPattern() method
    //		Using localized styles with FormatStyle, such as long or medium

    //Use inbuilt pattern constants
    static final DateTimeFormatter inBuiltFormatter1 = DateTimeFormatter.ISO_DATE_TIME;
    static final DateTimeFormatter inBuiltFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    //Define your own custom patterns
    static final DateTimeFormatter customFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' hh:mma z");
    static final DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    //Using FormatStyle
    static final DateTimeFormatter customFormatter9 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

    public static void main(String[] args) {
        String instanceString = customFormatter2.format(ZonedDateTime.now());
        System.out.println(instanceString);

        //Formatting with SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        String formattedDate = sdf.format(new Date());
        System.out.println(formattedDate);

        String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
        SimpleDateFormat sdfWithLocale = new SimpleDateFormat(pattern, new Locale("fr", "FR"));
        String date = sdfWithLocale.format(new Date());
        System.out.println(date);

        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setAmPmStrings(new String[]{"AM", "PM"});
        sdf.setDateFormatSymbols(symbols);
        formattedDate = sdf.format(new Date());
        System.out.println(formattedDate);
    }
}
