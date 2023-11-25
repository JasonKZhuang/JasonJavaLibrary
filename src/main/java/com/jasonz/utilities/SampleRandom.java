package com.jasonz.utilities;

import java.util.Random;

public class SampleRandom
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random r = new Random();
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(100));
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		System.out.println(r.nextDouble());
		System.out.println(r.nextBoolean());

	}

}
