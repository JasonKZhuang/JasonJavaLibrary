package com.jasonz;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.03.06 19:59
 * @project JasonJavaLibrary
 * @description: Question 52: Udemy
 */
public class MyTest<T> {
    private static int count;

    static {
        System.out.println("block 1");
        count = 10;
    }

    private int[] data;

    {
        System.out.println("block 2");
        data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    public static void main(String[] args) {


        //System.out.println(String.format("Local Time: %1$", Calendar.getInstance()));
        System.out.println(String.format("Local Time: %tH:%tM:%tS", Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance()));
        // System.out.println(String.format("Local Time: %tT", Calendar.getInstance().toString()));
        System.out.println(String.format("Local Time: %tT", Calendar.getInstance()));
        System.out.println(String.format("Local Time: %1$tB", Calendar.getInstance()));



        BigDecimal bigDecimal = new BigDecimal(100.00);
        double a = 123.45f;
        int iii = (int) (bigDecimal.doubleValue() * a);

        System.out.println(count);
        System.out.println("first");
        MyTest myTest1 = new MyTest();
        System.out.println("send");
        MyTest myTest2 = new MyTest();

        HashMap<String, Integer> aMap = new HashMap<>();
        String p1 = "Key1";
        String p2 = "123";
        ttt(aMap, p1, p2);
        Object v = aMap.get(p1);
        System.out.println(v.toString());

        int aNumber = 0;
        if (aNumber >= 0)
            ;

        if (aNumber == 0)
            ;
//        System.out.println("1");
//        else System.out.println("2");
//        System.out.println("3");


        String stringA = "Lesson6Distinct";
        String stringB = "B";
        String stringNull = null;
        StringBuilder bufferc = new StringBuilder("C");
        Formatter fmt  = new Formatter(bufferc);

        fmt.format("%s%s",stringA,stringB);
        System.out.println("Line 1 :" + fmt);

        fmt.format("%-2s",stringB);
        System.out.println("Line 2 :" + fmt);

        fmt.format("%b",stringNull);
        System.out.println("Line 3 :" + fmt);

    }

    public static void ttt(HashMap amap, Object p1, Object p2) {
        amap.put(p1, p2);
    }

    void display() {
        System.out.println("data = " + data);
    }

}

interface Account{
    BigDecimal balance = new BigDecimal(0.00);


}

class SavingsAccount implements Account{
    public SavingsAccount(BigDecimal initialValue){
        // balance = initialValue;
    }
}


class MyCollection<T>{
    private Set<T> set;
    public  Set<T> getCollection(){
        return this.set;
    }

    public void TestCollection(MyCollection<?> collection){
        Set<?> set = collection.getCollection();
        // InputStreamReader isr = new InputStreamReader("file.txt","UTF-16E");
    }

    public void TestCollection2(MyCollection<T> collection){
        Set<?> set = collection.getCollection();
    }
}
