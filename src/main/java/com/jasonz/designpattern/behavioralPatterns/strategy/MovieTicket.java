package com.jasonz.designpattern.behavioralPatterns.strategy;

import lombok.Data;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 * 策略模式(Strategy Pattern)：定义一系列算
 * 法类，将每一个算法封装起来，并让它们可以相互替换，策略模式让算法独立于使用它的客
 * 户而变化，也称为政策模式(Policy)。策略模式是一种对象行为型模式。
 *
 * 在策略模式结构图中包含如下几个角色：
 * 1 Context（环境类）：环境类是使用算法的角色，它在解决某个问题（即实现某个方法）时
 * 可以采用多种策略。在环境类中维持一个对抽象策略类的引用实例，用于定义所采用的策
 * 略。
 * 2 Strategy（抽象策略类）：它为所支持的算法声明了抽象方法，是所有策略类的父类，它可
 * 以是抽象类或具体类，也可以是接口。环境类通过抽象策略类中声明的方法在运行时调用具
 * 体策略类中实现的算法。
 * 3 ConcreteStrategy（具体策略类）：它实现了在抽象策略类中声明的算法，在运行时，具体策
 * 略类将覆盖在环境类中定义的抽象策略类对象，使用一种具体的算法实现某个业务处理。
 *
 * 策略模式是一个比较容易理解和使用的设计模式，策略模式是对算法的封装，它把算法的责
 * 任和算法本身分割开，委派给不同的对象管理。策略模式通常把一个系列的算法封装到一系
 * 列具体策略类里面，作为抽象策略类的子类。在策略模式中，对环境类和抽象策略类的理解
 * 非常重要，环境类是需要使用算法的类。在一个系统中可以存在多个环境类，它们可能需要
 * 重用一些相同的算法
 */
@Data
public class MovieTicket {
    private double price; //电影票价格
    private String type; //电影票类型

    /**
     * 通过MovieTicket类实现了电影票的折后价计算，该方案解决了电影票打折问题，每一种打折
     * 方式都可以称为一种打折算法，更换打折方式只需修改客户端代码中的参数，无须修改已有
     * 源代码，但该方案并不是一个完美的解决方案，它至少存在如下三个问题：
     * (1) MovieTicket类的calculate()方法非常庞大，它包含各种打折算法的实现代码，在代码中出现
     * 了较长的if…else…语句，不利于测试和维护。
     * (2) 增加新的打折算法或者对原有打折算法进行修改时必须修改MovieTicket类的源代码，违反
     * 了“开闭原则”，系统的灵活性和可扩展性较差。
     * (3) 算法的复用性差，如果在另一个系统（如商场销售管理系统）中需要重用某些打折算法，
     * 只能通过对源代码进行复制粘贴来重用，无法单独重用其中的某个或某些算法（重用较为麻
     * 烦）。
     * 如何解决这三个问题？导致产生这些问题的主要原因在于MovieTicket类职责过重，它将各种
     * 打折算法都定义在一个类中，这既不便于算法的重用，也不便于算法的扩展。因此我们需要
     * 对MovieTicket类进行重构，将原本庞大的MovieTicket类的职责进行分解，将算法的定义和使
     * 用分离，这就是策略模式所要解决的问题
     * @return
     */
    public double calculate() {
        //学生票折后票价计算
        if (this.type.equalsIgnoreCase("student")) {
            System.out.println("学生票：");
            return this.price * 0.8;
        }

        //儿童票折后票价计算
        else if (this.type.equalsIgnoreCase("children") && this.price >= 20) {
            System.out.println("儿童票：");
            return this.price - 10;
        }

        //VIP票折后票价计算
        else if (this.type.equalsIgnoreCase("vip")) {
            System.out.println("VIP票：");
            System.out.println("增加积分！");
            return this.price * 0.5;
        } else {
            return this.price; //如果不满足任何打折要求，则返回原始票价
        }
    }
}
