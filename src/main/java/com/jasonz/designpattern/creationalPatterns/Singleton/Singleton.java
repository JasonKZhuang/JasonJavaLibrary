package com.jasonz.designpattern.creationalPatterns.Singleton;

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    synchronized public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
