/**
 * Project: JasonJavaLibrary
 * Date: 28/11/2022
 * Author: Jason
 */
package com.jasonz.core.myEnum;

/**
 * In this guide to Java enum with string values, learn to
 * create enum using strings,
 * iterate over all enum values,
 * get enum value and perform a reverse lookup to find enum by string parameter.
 */
public enum EnumWithStrings {

    PROD("https://prod.domain.com:1088/"),
    SIT("https://sit.domain.com:2019/"),
    CIT("https://cit.domain.com:8080/"),
    DEV("https://dev.domain.com:21323/");

    private String url;

    EnumWithStrings(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }

}
