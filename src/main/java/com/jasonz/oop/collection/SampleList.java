package com.jasonz.oop.collection;

import java.util.ArrayList;
import java.util.List;

import com.jasonz.oop.inherit.Animal;
import com.jasonz.oop.inherit.Elephant;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17
 * copywrite kkcms.com
 */
public class SampleList
{
	private List<Animal> myList = new ArrayList<Animal>();
	
	public void add()
	{
		Elephant obj = new Elephant();
		myList.add(obj);
	}
}

