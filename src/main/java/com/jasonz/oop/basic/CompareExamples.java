package com.jasonz.oop.basic;

/**
 * @author Jason Zhuang
 * @created 2024.03.20 17:08
 * @project JasonJavaLibrary
 * @description:
 */
public class CompareExamples {

    public static void main(String[] args) {
        // Integer Compare
        Integer x = 3;
        Integer y = null;

        try {
            // System.out.println(Integer.compare(x, 3 ) == 0 );

            //Cannot invoke "java.lang.Integer.intValue()" because "y" is null
            // System.out.println(Integer.compareUnsigned(y,0) == 0);

            boolean b = (Integer.compare(x, 3) == 0) ||
                        (Integer.compareUnsigned(y, 0) == 0);
            System.out.println(b);

        } catch (Exception e) {
            System.out.println(e.getClass().toString());
        }

        try {
            System.out.println(y.compareTo(null) == 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
