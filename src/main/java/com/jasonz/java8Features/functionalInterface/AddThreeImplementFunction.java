package com.jasonz.java8Features.functionalInterface;

import java.util.function.Function;

/**
 * Long is the given parameter
 * String is the return value
 */
public class AddThreeImplementFunction implements Function<Integer, Long> {

    @Override
    public Long apply(Integer arg) {
        return (long) (arg + 3);
        //return String.format("The return value [%d] + 3 is [%d]", aLong, aLong + 3);
    }

}