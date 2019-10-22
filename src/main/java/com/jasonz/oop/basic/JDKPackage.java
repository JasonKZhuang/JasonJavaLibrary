package com.jasonz.oop.basic;

public class JDKPackage
{
	/*
	 * java.lang 包  包含线程类 Thread 异常类Exception 系统类 System 整数类 Integer 字符串类 String
	 * java.awt  抽象窗口工具包 包含用于构件GUI界面类和绘图类
	 * java.io   输入/输出包    包含各种输入流类和输出流类如文件输入流类FileInputStream 文件输出流类FileOutputStream
	 * java.util 提供一些实用类如 日期类Date 和 集合类 Collection
	 * java.net  支持TCP/IP的网络协议，包含Socket类和URL类  这些类用于网络编程
	 * ---------------------------------------------------------------
	 * javac编译 实例 在dos下运行 
	 * javac -verbose  输出详细工作信息 
	 * 		 -sourcepath c:\pro\zkzpro\src 
	 *       -classpath  c:\pro\zkzpro\classes 
	 *       -d          c:\pro\zkzpro\classes   指定编译类文件存放的路径
	 *       c:\pro\zkzpro\src\com\zkz\test.java
	 *       c:\pro\zkzpro\src\com\zkz\other\*.java 多个文件用空格隔开
	 * ----------------------------------------------------------------
	 * java运行
	 * 在操作系统中设置环境变量
	 * 在dos下设置当前classpath
	 * c:\set classpath=c:\pro\zkzpro\
	 * c:>java -classpath c:\lib\mytools.jar someclass
	 * c:>java -classpath .;%classpath%;c:\pro\zkzpro\classes;c:\lib\mytools.jar  someclass
	 * c:>java -classpath  c:\pro\zkzpro\classes com.zkz.AppMain 必须指定主程序完整的名字
	 * ------------------------------------------------------------------
	 * java 打包
	 * dos命令转到c:\pro\zkzpro\classes目录下执行
	 * c:\pro\zkzpro\classes>jar -cvf c:\pro\zkzpro\deploy\prozkz.jar *.*
	 * 
	 * */
}

