package com.jasonz.designpattern.creationalPatterns.Singleton;

/**
 * To implement a singleton pattern, we have different approaches,
 * but all of them have the following common concepts.
 * - Private constructor to restrict instantiation of the class from other classes.
 * - Private static variable of the same class that is the only instance of the class.
 * - Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.
 */
public class Singleton {

    /**
     * The volatile keyword ensures that any changes made to the instance variable are immediately visible to all threads,
     * preventing potential issues in a Multi threaded Scenario where multiple threads might be accessing the instance variable simultaneously.
     * This is crucial for the correct functioning of the Singleton pattern in a Multi threaded environment.
     */
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    /**
     * It's declared as synchronized, which means only one thread can execute this method at a time.
     * This ensures that multiple threads cannot create multiple instances of the Singleton class simultaneously.
     */
    synchronized public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
