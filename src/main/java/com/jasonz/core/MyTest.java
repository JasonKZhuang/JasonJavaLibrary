package com.jasonz.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 31/1/2022
 * @description :
 */
public class MyTest {

    public static void main(String[] args) {
        String mNumber = "61041 YYYY234567poi";
        List<String> ruleList = new ArrayList<>();
        ruleList.add("6104");
        ruleList.add("04");
        ruleList.add("4");

        //a. Filter out any non-numerical characters, including spaces
        mNumber = mNumber.replaceAll("[^\\d]", "");
        //b. Check the prefix (country code) of the numbers to ensure it is an Australian mobile
        if (StringKits.usingStartsWith(mNumber,ruleList).equals("")){
            return;
        }
        //c.Check the length of the number equals 11
        if (mNumber.length() !=11){
            return;
        }
        //d. check the mobile number blacklist

        System.out.println(mNumber);


    }

}
