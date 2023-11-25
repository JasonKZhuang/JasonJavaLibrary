package com.jasonz.utilities;

/**
 * String 与StringBuffer类的共同点：
 * 1.都是用来处理字符串
 * 2.都提供了Length(),toString(),charAt(),substring()方法，他们的用法在两个类相同
 * 3.字符串索引位置都是从0开始
 * 4.substring(int beginIndex, int endIndex)
 * 
 * String 与StringBuffer类的不同点 
 * 1.String的内容不可以改变,它的一些方法不会改变字符串本身，而是创建并返回一个包含改过内容的新字符串
 * 2.StringBuffer表示字符串缓存内容是可以改变的，方法有append(),replaceAll(),replaceFirst(),insert()等
 * 3.StringBuffer没有覆盖Object对象的equals()方法
 * 4.StringBuffer不能用+操作符进行连接
 * 
 */
public class SampleStringBuffer
{

	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
