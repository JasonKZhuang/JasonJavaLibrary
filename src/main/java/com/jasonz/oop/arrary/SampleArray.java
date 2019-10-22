package com.jasonz.oop.arrary;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17
 * copywrite kkcms.com
 */
public class SampleArray
{
	//数组声明
	private int[]  scores;
	private String[] names;
	
	private int    scores2[];
	private String  names2[];
	
	//二维数组声明
	private int x[][];
	
	//声明数组时候不能指定数组长度,以下是错误的
	//private int a[5];
	
	
	
	public void test()
	{
		//创建数组对象
		scores = new int[100];
		scores[0]=100;
		
		//数组长度用变量表示
		int size=100;
		scores2 = new int[size];

		//数组对象引用
		scores2=scores;
		
		System.out.println("scores[0]="+scores[0]);
		System.out.println("scores2[0]="+scores2[0]);
		
		scores2[0]=200;
		System.out.println("scores[0]="+scores[0]);
		System.out.println("scores2[0]="+scores2[0]);
		System.out.println("scores2.equals(scores) is "+scores2.equals(scores));
		
		//数组初始化
		int[] scores3 = new int[]{1,2,3,4,5};
		for (int i = 0; i < scores3.length; i++)
		{
			System.out.println(scores3[i]);
		}
		
		//多维数组
		String[][] rooms = new String[3][];//三层楼,每层楼有不同的房间数
		rooms[0] = new String[5];
		rooms[1] = new String[4];
		rooms[2] = new String[3];
		
		rooms[0][0]="Tom";
		rooms[0][4]="Jemy";
		rooms[1][0]="Karen Marsh";
		rooms[1][3]="Dim work";
		rooms[2][0]="Chris";
		rooms[2][2]="Linda";
		
		for (int i = 0; i < rooms.length; i++)
		{
			for (int j = 0; j < rooms[i].length; j++)
			{
				System.out.println("rooms["+i+"]["+j+"] is "+rooms[i][j]);
			}
		}
		
		
		//Arrays实用类
		//Arrays.
		
		
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SampleArray  obj = new SampleArray();
		obj.test();
	}
	
}

