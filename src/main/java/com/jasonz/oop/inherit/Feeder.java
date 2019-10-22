package com.jasonz.oop.inherit;
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
	protected void feed(Animal animal,Food food)
	{
		System.out.println("饲养员开始喂养动物食物");
		animal.eat(food);
	}
}

