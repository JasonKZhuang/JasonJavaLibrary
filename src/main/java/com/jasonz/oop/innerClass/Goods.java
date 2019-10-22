package com.jasonz.oop.innerClass;

/**
 * @creator Jason Zhuang
 * @create-time 2013-6-27
 * 本实例主要测试内部类的应用
 * 为什么需要内部类？
 * java内部类有什么好处？为什么需要内部类？
 * 首先举一个简单的例子，
 * 如果你想实现一个接口，但是这个接口中的一个方法和你构想的这个类中的一个方法的名称，参数相同，你应该怎么办？
 * 这时候，你可以建一个内部类实现这个接口。
 * 由于 内部类 对 外部类 的所有内容都是可访问的，
 * 所以这样做可以完成所有你直接实现这个接口的功能。
 * 
 * 不过你可能要质疑，更改一下方法的不就行了吗？
 * 的确，以此作为设计内部类的理由，实在没有说服力。
 * 真正的原因是这样的，java中的内部类和接口加在一起，
 * 可以的解决常被C++程序员抱怨java中存在的一个问题 没有多继承。
 * 实际上，C++的多继承设计起来很复杂，而java通过内部类加上接口，可以很好的实现多继承的效果。
 * copywrite kkcms.com
 */
public class Goods
{
	private int valueRate = 2;
	
	//定义内部类实现IContents接口，该类只是在Goods类中可访问
	private class Content implements IContents
	{
		//内部类成员变量可以访问外部了的成员变量
		//这事内部类的第2个好处
		private int innerContent_i = 11 * valueRate;
		
		//获得内部类中的私有成员变量值innerContent_i
		public int value()
		{
			return innerContent_i;
		}
		
	}
	
	//定义内部类实现IDestination接口，该类为public类
	protected class Destination implements IDestination
	{
		private String innerDest_label;  
        private Destination(String whereTo) 
        {  
        	innerDest_label = whereTo;  
        }  
        
		public String readLabel()
		{
			return innerDest_label;
		}
		
	}
	
	public IDestination dest(String s)
	{
		return new Destination(s);
	}
	
	public IContents   cont()
	{
		return new Content();
	}
	
	//局部内部类,内部类定义在方法内
	//如果我们在用一个内部类的时候仅需要创建它的一个对象并创付给外部，就可以这样做
	public IDestination dest(String s,String e)
	{
		class DestinationImpl implements IDestination
		{
			private String start;
			private String end;
			private DestinationImpl(String s,String e)
			{
				start = s;
				end   = e;
			}
			
			public String readLabel()
			{
				return start+"---"+end;
			}
		}
		return new DestinationImpl(s , e);
	}
	
	
}

