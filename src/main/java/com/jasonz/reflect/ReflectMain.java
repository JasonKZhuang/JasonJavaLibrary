/**
 * Project: JasonJavaLibrary
 * Date: 3/10/2022
 * Author: Jason
 */
package com.jasonz.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ReflectMain {

    public static void main(String[] args) {
        Product product = new Product(1,"car",123.456f,null);
        product.setId(1);
        product.setName("car");
        product.setPrice(123.456f);
        product.setContent("Toyota");

        ReflectMain ins = new ReflectMain();
        Map<String, String> map = new HashMap<>();
        try {
//            map = ins.getSortMap(product, "getter");
            map = ins.getSortMap(product, "get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 使用java反射机制，动态获取对象的属性和参数值，排除值为null的情况，并按字典序排序
     *
     * @param object
     * @return
     * @throws Exception
     */
    private Map<String, String> getSortMap(Object object, String argMethod) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, String> map = new HashMap<String, String>();
        //迭代属性
        for (Field field : fields) {
            String name = field.getName();
            Object value = null;

            // 调用getter方法获取属性值
            if (argMethod.equals("getter")) {
                String methodName = "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
                Method myMethod = object.getClass().getMethod(methodName);
                value = myMethod.invoke(object) + "";
            }

            //通过get方法直接获取属性值
            if (argMethod.equals("get")) {
                field.setAccessible(true);
                value = field.get(object);
            }

            if (value != null) {
                map.put(name, value.toString());
            }
            System.out.println("字段名：" + name);
            System.out.println("字段值：" + value);
            System.out.println("字段java语言修饰符：" + field.getModifiers());
            System.out.println("字段类型：" + field.getType());
            System.out.println();
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String arg0, String arg1) {

                        return arg0.compareTo(arg1);
                    }
                });
        sortMap.putAll(map);
        return sortMap;
    }

}
