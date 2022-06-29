package com.jasonz.leetcode.arrayAndString;

import java.util.HashMap;
import java.util.Map;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger ins = new StringToInteger();
        String s = "20000000000000000000";
//        s="42";
        s = "  +  413";
        System.out.println(ins.myAtoi(s));
    }

    public int myAtoi(String s) {
        int retValue = 0;
        Map<Character, Integer> times = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (c == ' ') {
                if (i == 0) {
                    continue;
                }
                if (chars[i - 1] == ' ') {
                    continue;
                } else {
                    break;
                }
            } else if (c == '-') {
                if ((i > 0) && (Character.isDigit(chars[i - 1]) || (chars[i - 1] == c))) {
                    break;
                } else {
                    times.put(c, -1);
                }
            } else if (c == '+') {
                if ((i > 0) && (Character.isDigit(chars[i - 1]) || (chars[i - 1] == c))) {
                    break;
                } else {
                    times.put(c, 1);
                }
            } else if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }

        if (sb.length() == 0) {
            return 0;
        }

        if (times.size() == 0) {
            times.put('+', 1);
        }

        long sum = 0;
        try {
            long v = Long.valueOf(sb.toString());
            for (Map.Entry<Character, Integer> e : times.entrySet()) {
                sum = sum + v * e.getValue();
            }
        } catch (Exception exp) {
            if (times.get('+') != null && (times.get('-') != null)) {
                sum = 0;
            } else if (times.get('+') != null && times.get('+') == 1) {
                sum = Integer.MAX_VALUE;
            } else if (times.get('-') != null && times.get('-') == -1) {
                sum = Integer.MIN_VALUE;
            }
        }

        if (sum < Integer.MIN_VALUE) {
            retValue = Integer.MIN_VALUE;
        } else if (sum > (Integer.MAX_VALUE - 1)) {
            retValue = (Integer.MAX_VALUE);
        } else {
            retValue = (int) sum;
        }

        return retValue;
    }

    public int myAtoiOptimal(String s) {
        int index = 0;
        int result = 0;
        int sign = 1;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < n && Character.isDigit(s.charAt(index))) {
            char c = s.charAt(index);
            int digit = c - '0';
            // int digit = Character.getNumericValue(s.charAt(index));
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + digit;
            index++;
        }

        return sign * result;

    }
}
