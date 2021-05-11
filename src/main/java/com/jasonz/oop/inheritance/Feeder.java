package com.jasonz.oop.inheritance;

import com.jasonz.oop.inheritance.children.Bone;
import com.jasonz.oop.inheritance.children.Cat;
import com.jasonz.oop.inheritance.children.Dog;
import com.jasonz.oop.inheritance.children.Fish;

/**
 * @creator Peter Zhuang
 * @create-time 2013-6-25
 * copywrite kkcms.com
 */
public class Feeder
{
	//定义 public变量
	//定义 package变量
	//定义 protected变量
	//定义 private变量

	/**
	 * 喂养动物
	 */
	protected void feed(BaseAnimal animal,Food food)
	{
		System.out.println("饲养员开始喂养动物食物");
		animal.eat(food);
	}
	
	public static void main(String[] args)
	{
		Feeder feeder = new Feeder();
		BaseAnimal animal1 = new Dog();
		Food food1 = new Bone("Bone");
		feeder.feed(animal1, food1);
		
		BaseAnimal animal2 = new Cat();
		Food food2 = new Fish("fish");
		feeder.feed(animal2, food2);
	}
}

