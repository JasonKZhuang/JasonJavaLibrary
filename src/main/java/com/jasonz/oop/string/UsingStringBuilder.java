package com.jasonz.oop.string;

/**
 * StringBuilder: 
   Java StringBuilder class is used to create mutable (modifiable) string. 
   The Java StringBuilder class is same as StringBuffer class except that it is non-synchronized. 
   It is available since JDK 1.5.
 * @author Kaizhi Zhuang
 * @date 2021年5月30日
 */
public class UsingStringBuilder
{
	public static void main(String[] args)
	{
		StringBuilder sb=new StringBuilder("Hello ");  
		sb.append("Java");//now original string is changed  
		System.out.println(sb);//prints Hello Java  
		
		sb.insert(1,"Java");//now original string is changed  
		System.out.println(sb);//prints HJavaello  
		
		sb.replace(1,3,"Java");  
		System.out.println(sb);//prints HJavalo  
		
		sb.delete(1,3);  
		System.out.println(sb);//prints Hlo  
		
		sb.reverse();  
		System.out.println(sb);//prints olleH  
	}
}
