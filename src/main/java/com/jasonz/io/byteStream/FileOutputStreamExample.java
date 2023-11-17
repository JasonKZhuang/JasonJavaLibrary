package com.jasonz.io.byteStream;

import java.io.*;

/**
 * @author : Jason Zhuang
 * @date : 26/4/2022
 * @description :
 * 该类用来创建一个文件并向文件中写数据。如果该流在打开文件进行输出前，目标文件不存在，那么该流会创建该文件。
 */
public class FileOutputStreamExample {
    public static void main(String[] args) {
        FileOutputStreamExample ins = new FileOutputStreamExample();
        // ins.testFileOutputStreamWriteChar();
        // ins.testFileOutStreamWriteChunks();
        ins.testFileOutputStreamBufferedOutputStream();
    }

    /**
     * reading and writing file byte by byte, which is not efficient
     */
    public void testFileOutputStreamWriteChar() {
        InputStream is = null;
        OutputStream os = null;
        try {
            String currentPath = new File(".").getCanonicalPath();

            // Creating file object and specifying path
            // 首先得使用 File() 方法来创建一个文件对象
            File fileRead = new File(currentPath + "/file.txt");
            File fileWrite = new File(currentPath + "/file2.txt");

            // 使用一个文件对象来创建一个输入流对象来读取文件
            is = new FileInputStream(fileRead);
            // 使用一个文件对象来创建一个输出流对象来写入文件
            os = new FileOutputStream(fileWrite);
            int myInt = 0;
            // read till the end of the file
            while ((myInt = is.read()) != -1) {
                // converts integer to character
                char c = (char) myInt;
                os.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFileOutStreamWriteChunks() {
        int eof = 0;
        try {
            String currentPath = new File(".").getCanonicalPath();
            String inputFileName = currentPath + "/myself.jpg";
            String outputFileName = currentPath + "/myself2.jpg";
            FileInputStream fis = new FileInputStream(inputFileName);
            FileOutputStream fos = new FileOutputStream(outputFileName);
            do {
                byte[] data = new byte[1024];
                eof = fis.read(data);
                fos.write(data);
            } while (eof != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFileOutputStreamBufferedOutputStream() {
        try {
            String currentPath = new File(".").getCanonicalPath();
            String inputFileName = currentPath + "/myself.jpg";
            String outputFileName = currentPath + "/myself2.jpg";

            InputStream fin = new FileInputStream(inputFileName);
            OutputStream fout = new FileOutputStream(outputFileName);

            BufferedInputStream bins = new BufferedInputStream(fin);
            BufferedOutputStream bouts = new BufferedOutputStream(fout);

            int eof = 0;
            byte[] data = new byte[2048];
            do {
                eof = bins.read(data);
                bouts.write(data);
            } while (eof != -1);
            bouts.close();
            fout.close();
            bins.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
