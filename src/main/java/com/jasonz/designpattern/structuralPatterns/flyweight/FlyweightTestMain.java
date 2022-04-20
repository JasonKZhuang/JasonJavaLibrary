package com.jasonz.designpattern.structuralPatterns.flyweight;

public class FlyweightTestMain
{
	private static IgoChessmanFactory factory = null;

	public static void main(String[] args)
	{
		ABS_IgoChessman black1,black2,black3,white1,white2;
		factory  = IgoChessmanFactory.getInstance();
		
		black1 = IgoChessmanFactory.getIgoChessman("b");
		black2 = IgoChessmanFactory.getIgoChessman("b");
		black3 = IgoChessmanFactory.getIgoChessman("b");
		
		white1 = IgoChessmanFactory.getIgoChessman("w");
		white2 = IgoChessmanFactory.getIgoChessman("w");
		
		System.out.println("Are the black1 and black2 equal?：" + (black1==black2));
		System.out.println("Are the white1 and white2 equal?：" + (white1==white2));
		
		 
		black1.display(new Coordinates(1,2));
		black2.display(new Coordinates(3,4));
		black3.display(new Coordinates(5,6));
		
		white1.display(new Coordinates(7,8));
		white2.display(new Coordinates(9,9));
		

	}

}
