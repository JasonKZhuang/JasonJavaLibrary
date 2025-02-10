package com.jasonz.designpattern.creationalPatterns.builder;

import com.jasonz.designpattern.creationalPatterns.builder.ActorExample.AbstractActorBuilder;
import com.jasonz.designpattern.creationalPatterns.builder.ActorExample.ActorController;
import com.jasonz.designpattern.creationalPatterns.builder.ActorExample.ActorProdoct;
import com.jasonz.designpattern.creationalPatterns.builder.MealExample.KFCWaiter;
import com.jasonz.designpattern.creationalPatterns.builder.MealExample.Meal;
import com.jasonz.designpattern.creationalPatterns.builder.MealExample.MealBuilder;

public class BuilderPatternMain {

    public static void main(String[] args) {

        //动态确定套餐种类
        MealBuilder mb = (MealBuilder) XMLUtil.getBean("builderMealClassName");
        //服务员是指挥者
        KFCWaiter waiter = new KFCWaiter();
        //服务员准备套餐
        waiter.setMealBuilder(mb);
        //客户获得套餐
        Meal meal = waiter.construct();

        System.out.println("套餐组成：");
        System.out.println(meal.getFood());
        System.out.println(meal.getDrink());
        System.out.println("====================================");
        //================================================================//
        ActorController director = new ActorController();
        AbstractActorBuilder builder = (AbstractActorBuilder) XMLUtil.getBean("builderActorClassName");
        ActorProdoct actor = director.constructProduct(builder); //通过指挥者创建完整的建造者对象
        String type = actor.getType();
        System.out.println(type + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());

    }

}
