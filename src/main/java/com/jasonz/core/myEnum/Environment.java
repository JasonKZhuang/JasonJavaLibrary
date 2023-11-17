package com.jasonz.core.myEnum;

import java.util.Arrays;
import java.util.Optional;

/**
 * In this guide to Java enum with string values, learn to
 * create enum using strings,
 * iterate over all enum values,
 * get enum value and perform a reverse lookup to find enum by string parameter.
 */
public enum Environment
{
    PROD("https://prod.domain.com:1088/"), 
    SIT("https://sit.domain.com:2019/"), 
    CIT("https://cit.domain.com:8080/"), 
    DEV("https://dev.domain.com:21323/");
 
    private String url;
 
    Environment(String envUrl) {
        this.url = envUrl;
    }
 
    public String getUrl() {
        return url;
    }

    //****** Reverse Lookup ************//
    public static Optional<Environment> get(String url) {
        return Arrays.stream(Environment.values())
                .filter(env -> env.url.equals(url))
                .findFirst();
    }
}