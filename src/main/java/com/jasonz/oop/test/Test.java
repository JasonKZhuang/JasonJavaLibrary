package com.jasonz.oop.test;

import com.jasonz.oop.utilities.IsNumberic;

public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String barcode = "00093499680050000001";
		System.out.println(barcode.substring(0,2));
		System.out.println(IsNumberic.isNumeric1(barcode.substring(11,barcode.length())));
		barcode="";
		if ( barcode.startsWith("CPAP") ||  barcode.startsWith("CPAY")){
			System.out.println("fdsa");
		}
	}

}
