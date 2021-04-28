package com.jasonz.oop.collection;

import java.util.ArrayList;
import java.util.List;

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
		
		instance.example1(gamesList);
		instance.example2(gamesList);
		instance.example3(gamesList);
		instance.example4(gamesList);

	}
	
	public void example1(List<String> gamesList)
	{
        System.out.println("------------Iterating by passing lambda expression--------------");  
        gamesList.forEach(games -> System.out.println(games));  
	}
	
	public void example2(List<String> gamesList)
	{
		System.out.println("------------Iterating by passing method reference---------------");  
        gamesList.forEach(System.out::println);  
	}
	
	public void example3(List<String> gamesList)
	{

		System.out.println("------------Iterating by using stream().forEachOrdered and passing lambda expression---------------");  
		gamesList.stream().forEachOrdered(games -> System.out.println(games));
	}

	public void example4(List<String> gamesList)
	{  
		System.out.println("------------Iterating by using stream().forEachOrdered and passing method reference---------------");  
		gamesList.stream().forEachOrdered(System.out::println);  
	}

	
	 
	 
}
