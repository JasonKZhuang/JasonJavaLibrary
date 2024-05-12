package com.jasonz.multiLanguages;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 22:50
 * @project JasonJavaLibrary
 * @description:
 */
public class SampleGlobalization {

    public static void main(String[] args) {
        SampleGlobalization.handleListResourceBundle();
    }

    private static void handleListResourceBundle() {
//        Locale.setDefault(Locale.US);
//        Locale locale = new Locale("fr", "CA");
//        ResourceBundle bundle = ResourceBundle.getBundle("NationalDay", locale);
//        int year = (int) bundle.getObject("year");
//        System.out.println(year);


        // 使用默认语言环境的资源束
        Locale.setDefault(Locale.US);
        ResourceBundle bundle = ResourceBundle.getBundle("MyResources");
        System.out.println(bundle.getString("greeting"));  // 输出 "Hello"
        System.out.println(bundle.getString("farewell"));  // 输出 "Goodbye"

        // 使用中文（简体）语言环境的资源束
        Locale locale_CN = new Locale("zh", "CN");
        ResourceBundle bundleZh = ResourceBundle.getBundle("MyResources", locale_CN);
        System.out.println(bundleZh.getString("greeting"));  // 输出 "你好"
        System.out.println(bundleZh.getString("farewell"));  // 输出 "再见"
    }

    private static class MyResources extends ListResourceBundle {
        protected Object[][] getContents() {
            return new Object[][]{
                    {"greeting", "Hello"},
                    {"farewell", "Goodbye"}
            };
        }
    }

    private static class MyResources_en_AU extends ListResourceBundle {
        protected Object[][] getContents() {
            return new Object[][]{
                    {"greeting", "Hello"},
                    {"farewell", "Goodbye"}
            };
        }
    }

    private static class MyResources_zh_CN extends ListResourceBundle {
        protected Object[][] getContents() {
            return new Object[][]{
                    {"greeting", "你好"},
                    {"farewell", "再见"}
            };
        }
    }
}



