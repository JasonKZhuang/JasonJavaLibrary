package com.jasonz.oop.inherit;
/**
 * @creator Peter Zhuang
 * @create-time 2013-6-25
 * 该类用于测试实现多态功能
 * 1.Feeder 饲养员类
 * 2.Animal动物类
 * 2.1 Dog 类 继承 Animal 类
 * 2.1 Cat 类 继承 Animal 类
 * 3.Food 食物类
 * 3.1 Bone 类 继承 Food 类
 * 3.1 Fish 类 继承 Food 类
 * Feeder 类 调用 feed方法传递不同的动物和食物参数 实现多态调用
 * 不同动物和食物类声明为父类，而实际指向是具体的 猫或狗 和 鱼或骨头
 * copywrite kkcms.com
 */
public class PolymorphicMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Feeder feeder = new Feeder();
		Animal animal_dog = new Dog();
		Animal animal_cat = new Cat();
		Food   food_bone  = new Bone();
		Food   food_fish  = new Fish();
		
		feeder.feed(animal_dog, food_bone);
		feeder.feed(animal_cat, food_fish);

	}

}

