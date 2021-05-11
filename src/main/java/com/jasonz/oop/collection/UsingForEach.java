package com.jasonz.oop.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * forEach() Signature in Iterable Interface
 * default void forEach(Consumer<super T>action)  
 * 
 * Java Stream forEachOrdered() Method
 * Along with forEach() method, Java provides one more method forEachOrdered(). It is used to iterate elements in the order specified by the stream.
 * Singnature:
	void forEachOrdered(Consumer<? super T> action)  
 */
public class UsingForEach
{

	public static void main(String[] args)
	{
		List<String> gamesList = new ArrayList<String>();
		gamesList.add("Football");
		gamesList.add("Cricket");
		gamesList.add("Chess");
		gamesList.add("Hocky");

		UsingForEach instance = new UsingForEach();

		instance.exampleListLambda(gamesList);
		instance.exampleSetLambda();
		instance.exampleListMethodReference(gamesList);
		instance.exampleSetMethodReference();
		instance.exampleStreamForEachLambda(gamesList);
		instance.exampleStreamForEachMethodReference(gamesList);
		instance.exampleIteratingOverMap();

	}

	public void exampleListLambda(List<String> gamesList)
	{
		System.out.println("------------Iterating by passing lambda expression--------------");
		gamesList.forEach(games -> System.out.println(games));
	}

	public void exampleSetLambda()
	{
		System.out.println("------------Iterating a Set by passing lambda expression--------------");
		Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
		uniqueNames.forEach(names -> System.out.println(names));
	}

	public void exampleListMethodReference(List<String> gamesList)
	{
		System.out.println("------------Iterating by passing method reference---------------");
		gamesList.forEach(System.out::println);
	}

	public void exampleSetMethodReference()
	{
		System.out.println("------------Iterating by passing method reference---------------");
		Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
		uniqueNames.forEach(System.out::println);
	}

	public void exampleStreamForEachLambda(List<String> gamesList)
	{
		System.out.println("------------Iterating by using stream().forEachOrdered and passing lambda expression---");
		gamesList.stream().forEachOrdered(games -> System.out.println(games));
	}

	public void exampleStreamForEachMethodReference(List<String> gamesList)
	{
		System.out.println("------------Iterating by using stream().forEachOrdered and passing method reference---");
		gamesList.stream().forEachOrdered(System.out::println);
	}

	public void exampleIteratingOverMap()
	{
		Map<Integer, String> namesMap = new HashMap<>();
		namesMap.put(1, "Larry");
		namesMap.put(2, "Steve");
		namesMap.put(3, "James");
		namesMap.forEach((key, value) -> System.out.println(key + " " + value));

		namesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
	}

}
