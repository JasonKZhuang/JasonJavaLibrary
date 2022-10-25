package com.jasonz.designpattern.creationalPatterns.Prototype.WeeklyLogExample;

import creationalPatterns.Prototype.WeeklyLogExample.WeeklyLog;

public class TestPrototypeMain
{

	public static void main(String[] args)
	{
		//创建原型对象
		WeeklyLog log_previous = new WeeklyLog();
		log_previous.setName("张无忌1");
		log_previous.setDate("第12周");
		log_previous.setContent("这周工作很忙，每天加班111");
		System.out.println("****周报****");
		System.out.println("周次：" + log_previous.getDate());
		System.out.println("姓名：" + log_previous.getName());
		System.out.println("内容：" + log_previous.getContent());
		System.out.println("--------------------------------");
		
		WeeklyLog log_new = null;
		try
		{
			//clone protype object
			log_new = (WeeklyLog) log_previous.clone();
			log_new.setDate("第13周");
			System.out.println("****周报****");
			System.out.println("周次：" + log_new.getDate());
			System.out.println("姓名：" + log_new.getName());
			System.out.println("内容：" + log_new.getContent());
		} catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //调用克隆方法创建克隆对象
		
		System.out.println(log_previous == log_new);
		System.out.println(log_previous.getDate() == log_new.getDate());
		System.out.println(log_previous.getName() == log_new.getName());
		System.out.println(log_previous.getContent() == log_new.getContent());
		

	}

}
