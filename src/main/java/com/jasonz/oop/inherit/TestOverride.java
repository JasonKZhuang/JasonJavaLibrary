package com.jasonz.oop.inherit;

/**
 * 该类用于测试方法覆盖
 * 如果子类中定义的方法，其名称，返回类型，参数签名与父类中的一致，那么子类的方法覆盖了父类的方法
 * 1、子类方法不能缩小父类方法的访问权限
 * 2、子类方法不能抛出比父类方法更多的异常
 * 3、方法覆盖只能在子类和父类之间，同一个类不可以
 * 4、父类的静态方法不能被子类覆盖成非静态方法
 * 5、子类可以定义与父类签名相同的静态方法
 * 6、父类的非静态方法不能被子类覆盖为静态方法
 * 7、父类的私有方法不能别子类覆盖，因为private 只属于一个类
 * 8、父类的抽象方法可以通过两种途径覆盖：一是子类重新声明父类方法，二是子类实现父类抽象方法
 * 9、父类的非抽象方法可以被子类覆盖为抽象方法  abstract
 */
public class TestOverride extends BaseClass
{
	
	/**
	 * 覆盖父类方法
	 */
	public String testBaseMethod(String as_Arg)
	{
		return "这是子类方法，覆盖了父类方法 --->"+as_Arg;
	}
	
	public static String testBaseStaticMethod(String as_Arg)
	{
		return "这是子类静态方法，覆盖了父类静态方法 --->"+as_Arg;
	}
	
	/**
	 * 在子类中访问父类的被屏蔽的方法和属性
	 * @param arg
	 * @return
	 */
	public String testSuperMethod(String arg)
	{
		return super.testBaseMethod("aaaaaaaaaaa");
	}
	
	
	/**
	 * 通过super语句调用这个类的父类构造函数
	 * @param arg
	 * @return
	 */
	public TestOverride()
	{
		super();
	}

	public static void main(String[] args)
	{
		BaseClass    base   = new BaseClass();
		BaseClass    self1  = new TestOverride();
		TestOverride self2  = new TestOverride();
		
		System.out.println(base.testBaseMethod("base"));
		
		System.out.println(self1.testBaseMethod("self1"));
		
		System.out.println(self2.testBaseMethod("self2"));
		
		System.out.println(base.testBaseStaticMethod(" base static"));
		
		System.out.println(self1.testBaseStaticMethod(" 这个特殊，调用的是父类静态方法，因为指针指向的是父类对象 static"));
		
		System.out.println(self2.testBaseStaticMethod(" self2 static"));
		
		//使用super
		System.out.println(self2.testSuperMethod(" self1 static"));
		
	}
}
