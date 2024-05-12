package com.jasonz.exception;

import com.jasonz.io.file.FileResourcesUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 13:35
 * @project JasonJavaLibrary
 * @description:
 */
public class TryWithResourcesStatement {

    private final String fileName = "data.json";

    public static void main(String[] args) throws IOException, URISyntaxException {
        TryWithResourcesStatement ins = new TryWithResourcesStatement();
        ins.testJavaVersion8();
        System.out.println("==================================");
        ins.testJavaVersion9();
    }

    private void testJavaVersion8() throws URISyntaxException {

        FileResourcesUtils app = new FileResourcesUtils();
        String myFileFullName = app.getFileFromResource(fileName).getPath();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(myFileFullName))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void testJavaVersion9() throws IOException, URISyntaxException {

        FileResourcesUtils app = new FileResourcesUtils();
        String myFileFullName = app.getFileFromResource(fileName).getPath();
        BufferedReader br = new BufferedReader(new FileReader(myFileFullName));
        String line;
        try (br) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
