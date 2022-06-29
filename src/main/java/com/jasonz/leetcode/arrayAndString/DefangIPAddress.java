package com.jasonz.leetcode.arrayAndString;

public class DefangIPAddress {
    public static void main(String[] args) {

    }
    public String defangIPaddr(String address) {
        //Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1"
        StringBuilder result = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String defangIPaddr2(String address) {
        int idx =address.indexOf(".",0);
        while (idx>0 && idx<address.length()){
            address = new StringBuilder(address).insert(idx,"[").insert(idx+2,']').toString();
            idx =address.indexOf(".",idx+2);
        }
        return address;
    }
}
