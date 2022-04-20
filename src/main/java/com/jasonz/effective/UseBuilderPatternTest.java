package com.jasonz.effective;

/**
 * @author : Jason Zhuang
 * @date : 18/4/2022
 * @description :
 */
public class UseBuilderPatternTest {
    public static void main(String[] args) {
        UseBuilderPattern ubp = UseBuilderPattern.Builder().calories(10).fat(5).build();
        ubp.setSodium(100);
        System.out.println(ubp.toString());
    }
}

