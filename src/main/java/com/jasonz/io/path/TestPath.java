package com.jasonz.io.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 20:01
 * @project JasonJavaLibrary
 * @description:
 */
public class TestPath {
    public static void main(String[] args) {
        Path path1 = Paths.get("target", ".");
        Path path2 = Path.of(path1.getParent().toString(), ".");
        Path path3 = path1.toAbsolutePath();
        File file = path1.toFile();
        boolean b1 = path1.equals(path2);
        boolean b2 = path1.equals(path3);
        boolean b3 = path1.equals(file);
        System.out.println(b1 + " " + b2 + " " + b3);


        Path pathA = Path.of("/a/b");
        Path pathB = Path.of("/a/c");
        System.out.println(pathA.resolve(pathB));
    }
}
