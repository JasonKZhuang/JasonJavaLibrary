package com.jasonz.java8Features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * https://www.journaldev.com/2389/java-8-features-with-examples
 * Java 8 has introduced forEach method in java.lang.Iterable interface so that
 * while writing code we focus on business logic. The forEach method takes
 * java.util.function.Consumer object as an argument, so it helps in having our
 * business logic at a separate location that we can reuse. Let’s see forEach
 * usage with a simple example.
 * 
 * @author Jason Zhuang 23 Jun. 2021
 *
 */
public class UsingForEach
{

	public static void main(String[] args)
	{
		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			myList.add(i);
		}

		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext())
		{
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
		}

		// The first way is: traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>()
		{

			public void accept(Integer t)
			{
				System.out.println("forEach anonymous class Value::" + t);
			}

		});

		// The second way is: traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);

	}

}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>
{

	public void accept(Integer t)
	{
		System.out.println("Consumer impl Value::" + t);
	}
}
