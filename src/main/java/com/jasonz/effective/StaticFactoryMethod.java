package com.jasonz.effective;

/**
 * @author : Jason Zhuang
 * @date : 18/4/2022
 * @description : https://www.jianshu.com/p/ceb5ec8f1174
 * 考虑使用静态工厂方法代替构造器, 用一个静态方法来对外提供自身实例的方法
 */
public class StaticFactoryMethod {
    int age = 10;
    int weight = 30;
    public static StaticFactoryMethod newChild(int age, int weight) {
        StaticFactoryMethod child = new StaticFactoryMethod();
        child.weight = weight;
        child.age = age;
        return child;
    }
    public static StaticFactoryMethod newChildWithWeight(int weight) {
        StaticFactoryMethod child = new StaticFactoryMethod();
        child.weight = weight;
        return child;
    }
    public static StaticFactoryMethod newChildWithAge(int age) {
        StaticFactoryMethod child = new StaticFactoryMethod();
        child.age = age;
        return child;
    }
}
