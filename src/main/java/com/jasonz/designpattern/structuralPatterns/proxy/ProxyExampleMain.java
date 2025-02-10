package com.jasonz.designpattern.structuralPatterns.proxy;

import com.jasonz.designpattern.structuralPatterns.proxy.dealwithLegacy.LegacyDataAccessObject;
import com.jasonz.designpattern.structuralPatterns.proxy.dealwithLegacy.ProxyDataAccessObject;

/**
 * @author Jason Zhuang
 * @created 2024.06.11 12:17
 * @project JasonJavaLibrary
 * @description:
 */
public class ProxyExampleMain {
    public static void main(String[] args) {

        LegacyDataAccessObject dao = new ProxyDataAccessObject();
        dao.fetchData();

    }
}
