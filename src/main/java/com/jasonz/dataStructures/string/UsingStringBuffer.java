package com.jasonz.dataStructures.string;

public class UsingStringBuffer
{
	public static void main(String[] args)
	{
		StringBuffer sb=new StringBuffer("Hello-");  
		sb.append("Java");//now original string is changed  
		System.out.println(sb);//prints Hello Java  
		
		sb.insert(1,"INSERT");//now original string is changed  
		System.out.println(sb);//prints HJavaello Java  
		
		sb.replace(1,3,"Replace");  
		System.out.println(sb);//prints HJavalo  
		
		sb.delete(1,3);  
		System.out.println(sb);//HplaceSERTello-Java
		
		sb.reverse();  
		System.out.println(sb);//prints avaJ-olleTRESecalpH  
	}
}
