package com.jasonz.excercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 */
public class MiddleDayCalculation {
    public static void main(String[] args) {
        System.out.println(middleOfDay("06:00", "18:00"));
        System.out.println(middleOfDay("07:00", "18:00"));
        System.out.println(middleOfDay("05:24", "20:33"));
    }

    public static String middleOfDay(String sDate1, String sDate2) {
        String strDate = "";
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date middleDate = new Date();
        long diff = 0;
        try {
            Date date1 = format.parse(sDate1);
            Date date2 = format.parse(sDate2);
            long s = date1.getTime();
            long e = date2.getTime();
            diff = e - (e - s) / 2;
            middleDate.setTime(diff);
            strDate = format.format(middleDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }
}
