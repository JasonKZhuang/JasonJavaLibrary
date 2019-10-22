package com.jasonz.oop.inherit;

import com.jasonz.oop.beans.DogBean;
import com.jasonz.oop.beans.MonkeyBean;
/**
 * 该类用于测试方法重载
 */
public class TestOverload
{
	public static void main(String[] args)
	{
		DogBean dog = new DogBean();
		MonkeyBean monkey = new MonkeyBean();
		
		TestOverload self = new TestOverload();
		self.doSomething(dog);
		self.doSomething(monkey);
		
		System.out.println(self.isSameCity("a", "a"));
		System.out.println(self.isSameCity("a", "b"));
		System.out.println(self.isSameCity("a", "a","b","b"));
		System.out.println(self.isSameCity("a", "a","b","c"));

	}
	
	/**
	 * /根据传递参数的不同做不同的动作1
	 * @param dog
	 */
	public void doSomething(DogBean dog)
	{
		System.out.println("传递的对象是 dog 所以做 跟 dog 相关的动作");
	}
	
	/**
	 * /根据传递参数的不同做不同的动作2
	 * @param monkey
	 */
	public void doSomething(MonkeyBean monkey)
	{
		System.out.println("传递的对象是 monkey 所以做 跟 monkey 相关的动作");
	}
	
	/**
	 * 根据传递的两个城市名称判断是否为相同城市
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	public boolean isSameCity(String arg1,String arg2)
	{
		return arg1.equals(arg2);
	}
	
	/**
	 * 根据传递的两个城市名称和国家都相同，判断是否为相同城市
	 * @param name1
	 * @param name2
	 * @param country1
	 * @param country2
	 * @return
	 */
	public boolean isSameCity(String name1,String name2,String country1,String country2)
	{
		return isSameCity(name1,name2)  &&   isSameCity(country1, country2);
	}
	

}
