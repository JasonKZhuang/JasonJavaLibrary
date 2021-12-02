package com.jasonz.java8Features.longAdder;

import java.util.Random;

/**
 * LongAdder中会维护一个或多个变量，这些变量共同组成一个long型的“和”。
 * 当多个线程同时更新（特指“add”）值时，为了减少竞争，可能会动态地增加这组变量的数量。
 * “sum”方法（等效于longValue方法）返回这组变量的“和”值。
 * 当我们的场景是为了统计技术，而不是为了更细粒度的同步控制时，并且是在多线程更新的场景时，LongAdder类比AtomicLong更好用。 
 * 在小并发的环境下，论更新的效率，两者都差不多。但是高并发的场景下，LongAdder有着明显更高的吞吐量，但是有着更高的空间复杂度。
 * 
 * 从上面的java doc来看，LongAdder有两大方法，add和sum。
 * 其更适合使用在多线程统计计数的场景下，在这个限定的场景下比AtomicLong要高效一些
 * 
 * @author Kaizhi Zhuang
 * @date 14 Sept 2021
 */
public class LongAdderApplying
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	
}
