package com.jasonz.designpattern.creationalPatterns.Singleton;


import com.jasonz.designpattern.creationalPatterns.Singleton.IoDH.IODHSingleton;
import com.jasonz.designpattern.creationalPatterns.Singleton.simple1.EagerSingleton;
import com.jasonz.designpattern.creationalPatterns.Singleton.simple2.LazySingleton;

public class SingletonTest {

    public static void main(String[] args) {
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();
        if (es1 == es2) {
            System.out.println("We get the same EagerSingleton Instance!");
        }

        LazySingleton lz1 = LazySingleton.getInstance();
        LazySingleton lz2 = LazySingleton.getInstance();
        if (lz2 == lz1) {
            System.out.println("We get the same LazySingleton Instance!");
        }

        IODHSingleton is1 = IODHSingleton.getInstance();
        IODHSingleton is2 = IODHSingleton.getInstance();
        if (is1 == is2) {
            System.out.println("We get the same IODHSingleton Instance!");
        }


    }

}
