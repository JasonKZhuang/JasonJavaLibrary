package com.jasonz.oop.io.byteStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author : Jason Zhuang
 * @date : 26/4/2022
 * @description :
 * FileInputStream 用于从文件读取数据，它的对象可以用关键字 new 来创建。
 */
public class FileInputStreamExample {

    public static void main(String[] args) {
        FileInputStreamExample ins = new FileInputStreamExample();
        // ins.testFileInputStreamReadChar();
        // ins.testFileInputStreamReadChunks();
        // ins.testByteArrayInputStream();
        ins.testFileInputStreamBufferedInputStream();
    }

    /**
     * 可以使用字符串类型的文件名来创建一个输入流对象来读取文件
     * 也可以使用一个文件对象来创建一个输入流对象来读取文件。
     * Note that this way is not very efficient.
     */
    public void testFileInputStreamReadChar() {
        InputStream is = null;
        try {
            String currentPath = new File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);

            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" + currentDir);

            // Creating file object and specifying path
            // 首先得使用 File() 方法来创建一个文件对象
            File file = new File(currentPath + "/file.txt");

            // 使用一个文件对象来创建一个输入流对象来读取文件
            is = new FileInputStream(file);
            int myInt = 0;
            // read till the end of the file
            while ((myInt = is.read()) != -1) {
                // converts integer to character
                char c = (char) myInt;
                System.out.print(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFileInputStreamReadChunks() {
        try {
            String currentPath = new File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);
            String fileName = currentPath + "/myself.jpg";
            FileInputStream fis = new FileInputStream(fileName);
            int i = 0;
            do {
                byte[] buf = new byte[1024];
                i = fis.read(buf);
                String value = new String(buf, StandardCharsets.UTF_8);
                System.out.println(value);
                System.out.println("================================================");
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java BufferedInputStream class is used to read information from stream.
     * It internally uses buffer mechanism to make the performance fast.
     * The important points about BufferedInputStream are:
     * When the bytes from the stream are skipped or read, the internal buffer automatically refilled from the contained input stream, many bytes at a time.
     * When a BufferedInputStream is created, an internal buffer array is created.
     */
    public void testFileInputStreamBufferedInputStream() {
        try {
            String currentPath = new File(".").getCanonicalPath();
            String inputFileName = currentPath + "/myself.jpg";
            InputStream fin = new FileInputStream(inputFileName);
            BufferedInputStream bins = new BufferedInputStream(fin);
            int eof = 0;
            byte[] data = new byte[1024];
            do {
                eof = bins.read(data);
                System.out.println(data.toString());
            } while (eof != -1);
            bins.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testByteArrayInputStream() {
        byte[] buffer = new byte[10];
        Random rnd = new Random();

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) rnd.nextInt();
        }

        ByteArrayInputStream b = new ByteArrayInputStream(buffer);
        System.out.println("All the elements in the buffer:");
        int num;
        while ((num = b.read()) != -1) {
            System.out.print(num + " ");
        }
    }
}
