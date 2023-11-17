package com.jasonz.io.characterStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author : Jason Zhuang
 * @date : 26/4/2022
 * @description :
 * 读取控制台输入:
 * Java 的控制台输入由 System.in 完成。
 * 为了获得一个绑定到控制台的字符流，你可以把 System.in 包装在一个 BufferedReader 对象中来创建一个字符流。
 */
public class BufferedReaderExample {
    public static void main(String[] args) {
        BufferedReaderExample instance = new BufferedReaderExample();
        instance.testConsoleInput();
        instance.testConsoleOutput();
    }

    /**
     * 从控制台读取字符串
     */
    private void testConsoleInput() {

        //创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //BufferedReader 对象创建后，我们便可以使用 read() 方法从控制台读取一个字符，或者用 readLine() 方法读取一个字符串。
        try {
            System.out.println("输入字符, 按下 'q' 键退出。");
            char c;
            //每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。 当流结束的时候返回 -1。该方法抛出 IOException。
            // 读取字符
            do {
                c = (char) br.read();
                System.out.println(c);
            } while (c != 'q');

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String str;
            System.out.println("Enter lines of text,'end' to quit.");
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("end"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从控制台输出字符串
     * 控制台的输出 由 print( ) 和 println() 完成。这些方法都由类 PrintStream 定义，System.out 是该类对象的一个引用。
     * PrintStream 继承了 OutputStream 类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。
     */
    private void testConsoleOutput() {
        //输出单个字符
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
        //注意：write() 方法不经常使用，因为 print() 和 println() 方法用起来更为方便。

        //输出字符串
        System.out.println("HelloWord One-------");
        System.out.println("HelloWord Two-------");
    }

    /**
     * The example reads a big file using buffering technique for greater efficiency.
     */
    public void testFileInputStreamBufferedReader() {
        Reader reader = null;
        BufferedReader br = null;
        try {
            String currentPath = new File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);
            String fileName = currentPath + "/myself.jpg";
            reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
            //The example reads a big file using buffering technique for greater efficiency.
            br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println();
    }

}

