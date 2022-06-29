package com.jasonz.leetcode.arrayAndString;

import junit.framework.TestCase;
import org.junit.Test;

public class StringToIntegerTest extends TestCase {
    StringToInteger ins = new StringToInteger();

    @Test
    public void testMyAtoi() {
        String s = "  +  413";
        int expected = 0;
        int actual = 0;

        actual = ins.myAtoiOptimal(s);
        assertEquals(expected, actual);

        s =" ++1";
        expected = 0;
        actual = ins.myAtoiOptimal(s);
        assertEquals(expected, actual);

        s ="+-42";
        expected = 0;
        actual = ins.myAtoiOptimal(s);
        assertEquals(expected, actual);

        s ="-9223372036854775809";
        expected = -2147483648;
        actual = ins.myAtoi(s);
        assertEquals(expected, actual);


    }
}