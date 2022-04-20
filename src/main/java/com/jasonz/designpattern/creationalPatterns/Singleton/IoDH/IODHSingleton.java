package com.jasonz.designpattern.creationalPatterns.Singleton.IoDH;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Apr 9, 2018
 * Singleton.java
 * Describe: Using "Initialization Demand Holder" technique to create singleton
 * It will use an inner class
 * The lazy loading and thread secure can be secured and it will not reduce the efficiency
 */
public class IODHSingleton {
    private IODHSingleton() {
        ;
    }

    public static IODHSingleton getInstance() {
        return HolderClass.instance;
    }

    private static class HolderClass {
        private final static IODHSingleton instance = new IODHSingleton();
    }
}
