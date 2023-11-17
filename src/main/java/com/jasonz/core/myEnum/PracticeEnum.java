/**
 * Project: JasonJavaLibrary
 * Date: 28/11/2022
 * Author: Jason
 */
package com.jasonz.core.myEnum;

import java.util.Optional;

/**
 * Reference:
 * https://howtodoinjava.com/java/enum/enum-tutorial/
 */
public class PracticeEnum {
    public static void main(String[] args) {
        PracticeEnum self = new PracticeEnum();
        System.out.println(BasicEnum.EAST.ordinal());
        System.out.println(BasicEnum.WEST.ordinal());
        System.out.println(BasicEnum.SOUTH.ordinal());
        System.out.println(BasicEnum.NORTH.ordinal());


        //
        self.iteratingOverEnumConstants();
        self.gettingEnumValue();
        self.gettingEnumByName("PROD");
        self.reverseLookup();
        self.testAsArgument(Environment.DEV);
    }

    private void iteratingOverEnumConstants() {
        for (Environment env : Environment.values()) {
            System.out.println(env.name() + " :: " + env.getUrl());
        }
    }

    private void gettingEnumValue(){
        //Using enum constant reference
        System.out.println( Environment.PROD.getUrl());
        System.out.println( Environment.DEV.getUrl());
    }

    private void gettingEnumByName(String argName){
        //First get enum constant reference from string
        Environment sitUrl = Environment.valueOf(argName);
        System.out.println(sitUrl.getUrl());
    }

    private void reverseLookup(){
        String url = "https://sit.domain.com:2019/";
        Optional<Environment> env = Environment.get(url);
        System.out.println(env.get());
    }

    private void testAsArgument(Environment arg){
        System.out.println(arg.getUrl());
    }
}
