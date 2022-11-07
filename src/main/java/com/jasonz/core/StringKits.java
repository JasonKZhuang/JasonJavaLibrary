package com.jasonz.core;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Jason Zhuang
 * @date : 31/1/2022
 * @description :
 */
public class StringKits {
    public static void main(String[] args) {
        StringKits kits = new StringKits();
        String phoneNumber = "24123456789";
        List<String> lst = new ArrayList<>();
        lst.add("6104");
        lst.add("04");
        lst.add("4");
        System.out.println(StringKits.usingStartsWith(phoneNumber,lst));


        //2. Check the prefix (country code) of the numbers to ensure it is an Australian mobile
        List<String> prefixes = new ArrayList<String>();
        prefixes.add("6104");
        prefixes.add("04");
        prefixes.add("4");
        System.out.println( kits.convertAustraliaNumber(phoneNumber,prefixes));

        //3 Check if the input string is null or blank or not
        System.out.println(StringKits.checkStringNullAndBlank(null));
        System.out.println(StringKits.checkStringNullAndBlank(""));
        System.out.println(StringKits.checkStringNullAndBlank(" "));
    }

    public static boolean checkStringNullAndBlank(String arg){
        return StringUtils.isEmpty(arg);
    }

    public static String usingStartsWith(String arg, List<String> prefix) {
        for (String v : prefix) {
            if (arg.startsWith(v)){
                return arg;
            }
        }
        return "";
    }

    public static String usingStartsWith2(String arg, List<String> prefix) {
        String retValue = "";
        Stream<String> a = prefix.stream().filter(
                (value) -> {
                    if (arg.startsWith(value)) {
                        return true;
                    }
                    return false;
                });
        return a.toString();
    }

    private String convertAustraliaNumber(String phoneNumber, List<String> prefixes){
        for (String v : prefixes) {
            if (phoneNumber.startsWith("614")){
                return phoneNumber;
            }
            if (phoneNumber.startsWith(v.trim())){
                if(phoneNumber.startsWith("6104")){
                    phoneNumber = "614".concat(phoneNumber.substring(4));
                } else if(phoneNumber.startsWith("04")){
                    phoneNumber = "614".concat(phoneNumber.substring(2));
                }else if(phoneNumber.startsWith("4")){
                    phoneNumber = "614".concat(phoneNumber.substring(1));
                }else{
                    phoneNumber = "";
                }
                return phoneNumber;
            }
        }
        return "";
    }

}
