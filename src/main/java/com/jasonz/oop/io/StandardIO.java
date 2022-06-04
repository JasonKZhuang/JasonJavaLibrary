package com.jasonz.oop.io;

import java.util.Scanner;

/**
 * @author : Jason Zhuang
 * @date : 31/5/2022
 * @description :
 */
public class StandardIO {
    public static void main(String[] args) {
        StandardIO ins = new StandardIO();
        // ins.challenge2();
        ins.challenge3();
    }

    private void challenge3() {
        System.out.print("================================");
        Scanner scan = new Scanner(System.in);
        // iterate through the file line by line
        while(scan.hasNextLine()){
            String input = scan.nextLine();
            StringBuilder columA = new StringBuilder();
            StringBuilder columB = new StringBuilder();
            char[] arrChar = input.toCharArray();
            for (int i = 0; i < arrChar.length; i++) {
                Character temp = arrChar[i];
                if (temp.equals(' ')){
                    continue;
                }
                if (Character.isDigit(temp) == false && columA.length()<10) {
                    columA.append(temp);
                } else if (columB.length()<3){
                    columB.append(temp);
                }
            }
            String str1 = String.format("%-15s", columA.toString());
            String str2 = String.format("%03d", Integer.parseInt(columB.toString()));
            System.out.print("\n" + str1 + str2);
        }
        scan.close();
        System.out.print("\n================================");

    }

    private void challenge2() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = 0d;
        String s = scan.nextLine();
        while (s.equals("")) {
            s = scan.nextLine();
            try {
                d = Double.parseDouble(s);
            } catch (Exception e) {
                break;
            }
            s = scan.nextLine();
        }

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    private void challenge1() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        while (a != 0) {
            System.out.println(a);
            a = scan.nextInt();
        }
        scan.close();
    }
}
