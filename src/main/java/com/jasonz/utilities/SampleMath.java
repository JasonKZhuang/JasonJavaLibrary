package com.jasonz.utilities;

public class SampleMath
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		double a=123.456d;
		double b=456.789d;
		//返回绝对值
		System.out.println(Math.abs(a));
		//返回大于或等于参数的最小整数
		System.out.println(Math.ceil(a));
		//返回小于或等于参数的最大整数
		System.out.println(Math.floor(a));
		
		System.out.println(Math.max(a, b));
		System.out.println(Math.min(a, b));
		
		//返回0.0 和 1.0 之间的都报了类型的随机数,包括0.0,但不包括1.0
		System.out.println(Math.random());
		//返回四舍五入的整数值
		System.out.println(Math.round(a));

	}
	
	public void testSouceTree()
	{
		System.out.println("Testing...");
	}

}
