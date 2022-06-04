package com.jasonz.excercise;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 */
public class PayslipCalculation {

    public static void main(String[] args) {
        System.out.println(calculateTax(180001));
        System.out.println(calculateTax(37009));
        System.out.println(calculateTax(37001));
        System.out.println(calculateTax(1));
    }

    public static String calculateTax(float income) {
        float tax;
        float tatCal = 0f;
        float base = 0f;
        if (income <= 18200) {
            return "0.00";
        } else if (income <= 37000) {
            tatCal = (income - 18200);
            tax = (tatCal * 0.19f);
        } else if (income <= 87000) {
            base = 3572f;
            tatCal = (income - 37000);
            tax = (tatCal * 0.325f);
        } else if (income <= 180000) {
            base = 19822;
            tatCal = (income - 87000);
            tax = (tatCal * 0.37f);
        } else {
            base = 54232;
            tatCal = (income - 180000);
            tax = (tatCal * 0.45f);
        }

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(false);
        nf.setRoundingMode(RoundingMode.UP);
        String r = nf.format(base + tax);
        return r;
    }
}
