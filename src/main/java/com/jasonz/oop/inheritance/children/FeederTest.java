package com.jasonz.oop.inheritance.children;

import com.jasonz.oop.inheritance.BaseAnimal;
import com.jasonz.oop.inheritance.Creature;

public class FeederTest
{

	public static void main(String[] args)
	{
		//declare a dog instance variable
		Dog dog = new Dog();
		//assign dog to Creature
		Creature creature = dog;
		//assign creature to Object
		Object obj = creature;
		
		
		BaseAnimal animal = new Cat();
		Cat myCat = (Cat) animal;
		Dog myDog = (Dog) animal;

	}

}
