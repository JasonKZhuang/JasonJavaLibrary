package com.jasonz.designpattern.creationalPatterns.Singleton.simple1;

/**
 * In this type, the instance of the singleton class is created eagerly during the class loading process,
 * regardless of whether it is needed or not.
 * The instance is created as soon as the class is loaded,
 * and it is readily available for use.
 * Eager initialization is suitable when the singleton instance is lightweight,
 * and its creation is not resource intensive.
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}
