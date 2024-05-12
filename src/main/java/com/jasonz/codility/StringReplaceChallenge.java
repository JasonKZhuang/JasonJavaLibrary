package com.jasonz.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Jason Zhuang
 * @created 2024.04.27 12:59
 * @project JasonJavaLibrary
 * @description:
 */
public class StringReplaceChallenge {
    public static void main(String[] args) {
        String t = "Hello, $fullName, classes wil begin on Monday";
        Map<String, String> p = new HashMap<>();
        p.put("firstname", "Jason");
        p.put("lastName", "Zhuang");
        p.put("fullName", "$firstname $lastName");
        System.out.println(replaceString(t, p));
    }

    public static String replaceString(String str, Map<String, String> params) {
        String retValue = str;

        while (retValue.contains("$")) {

            Set<String> keys = params.keySet();

            for(String k: keys){
                if (retValue.contains("$" + k)) {
                    retValue = retValue.replace("$" + k, params.get(k));
                }
            }
        }
        
        return retValue;
    }
}
