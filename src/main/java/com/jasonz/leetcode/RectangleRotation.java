package com.jasonz.leetcode;

/**
 * @author Jason Zhuang
 * @created 2024.01.24 14:19
 * @project JasonJavaLibrary
 * @description: Task
 * A rectangle with sides equal to even integers a and b is drawn on the Cartesian plane. Its center (the intersection point of its diagonals) coincides with the point (0, 0), but the sides of the rectangle are not parallel to the axes; instead, they are forming 45 degree angles with the axes.
 * <p>
 * How many points with integer coordinates are located inside the given rectangle (including on its sides)?
 * <p>
 * Example
 * For a = 6 and b = 4, the output should be 23
 * <p>
 * Input/Output
 * [input] integer a
 * <p>
 * A positive even integer.
 * <p>
 * Constraints: 2 ≤ a ≤ 10000.
 * <p>
 * [input] integer b
 * <p>
 * A positive even integer.
 * <p>
 * Constraints: 2 ≤ b ≤ 10000.
 * <p>
 * [output] an integer
 * <p>
 * The number of inner points with integer coordinates.
 */
public class RectangleRotation {

    /**
     * this one is not successful,gave up
     * @param argv
     */
    public static void main(String[] argv) {
        System.out.println(solution(6, 4));
    }

    private static int solution(int a, int b) {
        int count = 0;
        double cX = Math.abs((b * Math.cos(45) + a * Math.sin(45)) / 2);
        double cY = Math.abs((a * Math.cos(45) + b * Math.sin(45)) / 2);

        // the top left line: y = x + sqrt(2*b*b)
        // the bottom right line: y = x - sqrt(2*b*b)
        // the top right line: y = -x + sqrt(2*b*b)
        // the bottom left line: y = -x - sqrt(2*b*b)

        for (int i = (int) Math.ceil(-cX); i <= Math.floor(cX); i++) {
            for (int j = (int) Math.ceil(-cY); j <= Math.floor(cY); j++) {
                // get the point (i,j)
                double y1 = topLeft(i, a);
                double y2 = topRight(i, b);
                double y3 = bottomLeft(i, b);
                double y4 = bottomRight(i, a);
                if (Math.abs(i) <= cX && j <= y1 && j <= y2 && j >= y3 && j >= y4) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void c (){

    }

    // the top left line: y = x + sqrt(2*l*l)
    // l is the vertical distance from zero(0,0) to the straight line
    private static double topLeft(double x, int l) {
        double y = 0d;
        return x + Math.sqrt(2 * l * l);
    }

    // the top right line: y = -x + sqrt(2*b*b)
    private static double topRight(double x, int a) {
        double y = 0d;
        return -x + Math.sqrt(2 * a * a);
    }

    // the bottom right line: y = x - sqrt(2*b*b)
    private static double bottomRight(double x, int b) {
        double y = 0d;
        return x - Math.sqrt(2 * b * b);
    }

    // the bottom left line: y = -x - sqrt(2*b*b)
    private static double bottomLeft(double x, int a) {
        double y = 0d;
        return -x - Math.sqrt(2 * a * a);
    }

    private class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

}
