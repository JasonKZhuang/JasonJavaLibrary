package com.jasonz.io.file;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 * The getResource method is not working in the JAR file.
 * The getResourceAsStream method works everywhere.
 */
public class FileResourcesUtils {

    public static void main(String[] args) throws IOException, URISyntaxException {

        FileResourcesUtils app = new FileResourcesUtils();

        String fileName = "db.properties";
        // String fileName = "json/file1.json";

        System.out.println("getResourceAsStream : " + fileName);
        InputStream is = app.getFileFromResourceAsStream(fileName);
        printInputStream(is);

        System.out.println("\ngetResource : " + fileName);
        File file = app.getFileFromResource(fileName);
        readFileByFileReader(file);
        readFileByScanner(file);
        readFileByReadAllLines(file);
        readOneLineFromFileByReadAllLines(file);
        readFileByBufferReader(app.getFileFromResource(fileName).getPath());



//        System.out.println("\nget All Files From Resources folder");
//        // files from src/main/resources/json
//        List<File> files = app.getAllFilesFromResource("json");
//        for (File f : files) {
//            System.out.println("file : " + f);
//            printFile(f);
//        }

    }

    // print input stream
    public static void printInputStream(InputStream is) {
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // read file
    public static void readFileByFileReader(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            // Reads a single character.
            System.out.println(fileReader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileByScanner(File file) {
        try (Scanner scanner = new Scanner(file)) {
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileByReadAllLines(File file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String readOneLineFromFileByReadAllLines(File file) {
        String oneLine;
        try {
            oneLine = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8).get(0);
            System.out.println(oneLine);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return oneLine;
    }

    public static void readFileByBufferReader(String fileWithPath) {
        try {
            Path path = Paths.get(fileWithPath);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*
        get a file from the resources folder
        works everywhere, IDEA, unit test and JAR file.
     */
    public InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    /*
        The resource URL is not working in the JAR
        If we try to access a file that is inside a JAR,
        It throws NoSuchFileException (linux), InvalidPathException (Windows)
        Resource URL Sample: file:java-io.jar!/json/file1.json
     */
    public File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }
    }

    //Get all files from a resource folder. (NON-JAR environment)
    public List<File> getAllFilesFromResource(String folder) throws URISyntaxException, IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(folder);
        // walk the root path, we will walk all the classes
        List<File> collect = Files.walk(Paths.get(resource.toURI()))
                .filter(Files::isRegularFile)
                .map(x -> x.toFile())
                .collect(Collectors.toList());
        return collect;
    }
}
