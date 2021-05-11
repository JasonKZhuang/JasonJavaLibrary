package com.jasonz.oop.polymorphism;

import com.jasonz.oop.beans.Bicycle;
import com.jasonz.oop.beans.MountainBike;
import com.jasonz.oop.beans.RoadBike;
import com.jasonz.oop.inheritance.BaseAnimal;
import com.jasonz.oop.inheritance.Food;
import com.jasonz.oop.inheritance.children.Cat;
import com.jasonz.oop.inheritance.children.Dog;
import com.jasonz.oop.inheritance.children.Elephant;

/**
 * @author Jason.Zhuang
 * Oct 23, 2019
 * PolymorphismTest.java
 * Describe:  Polymorphism (多态性)
 */
public class PolymorphismTest
{

	public static void main(String[] args)
	{
		PolymorphismTest test = new PolymorphismTest();
		
		System.out.println(test.sum(10, 20));
		System.out.println(test.sum(10, 20, 30));
		System.out.println(test.sum(10.5, 20.5));
		
		
		Bicycle bike01, bike02, bike03;
	    bike01 = new Bicycle(20, 10, 1);
	    bike02 = new MountainBike(20, 10, 5, "Dual");
	    bike03 = new RoadBike(40, 20, 8, 23);
	    bike01.printDescription();
	    bike02.printDescription();
	    bike03.printDescription();
	    
	    
	    BaseAnimal a;  
	    a=new Dog();  
	    a.eat(new Food("Bone"));  
	    a=new Cat();  
	    a.eat(new Food("Fish"));  
	    a=new Elephant();  
	    a.eat(new Food("Apple"));  

	}

	// Overloaded sum().
	// This sum takes two int parameters
	public int sum(int x, int y)
	{
		return (x + y);
	}

	// Overloaded sum().
	// This sum takes three int parameters
	public int sum(int x, int y, int z)
	{
		return (x + y + z);
	}

	// Overloaded sum().
	// This sum takes two double parameters
	public double sum(double x, double y)
	{
		return (x + y);
	}

}
