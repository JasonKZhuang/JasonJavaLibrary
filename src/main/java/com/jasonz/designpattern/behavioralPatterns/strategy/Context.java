package com.jasonz.designpattern.behavioralPatterns.strategy;

import lombok.Data;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 * 在Context类中定义一个AbstractStrategy类型的对象strategy，通过注入的方式在客户端传入一个具体策略对象
 *
 * 在客户端代码中只需注入一个具体策略对象，可以将具体策略类类名存储在配置文件中，通
 * 过反射来动态创建具体策略对象，从而使得用户可以灵活地更换具体策略类，增加新的具体
 * 策略类也很方便。策略模式提供了一种可插入式(Pluggable)算法的实现方案。
 */
@Data
public class Context {
    private AbstractStrategy strategy; //维持一个对抽象策略类的引用

    //调用策略类中的算法
    public void algorithm() {
        strategy.algorithm();
    }

    public static void main(String[] args) {
        Context context = new Context();
        AbstractStrategy strategy;
        //Concrete Strategy Lesson6Distinct
        strategy = new ConcreteStrategyA(); //可在运行时指定类型
        context.setStrategy(strategy);
        context.algorithm();

        //Concrete Strategy B
        strategy = new ConcreteStrategyB(); //可在运行时指定类型
        context.setStrategy(strategy);
        context.algorithm();
    }
}
