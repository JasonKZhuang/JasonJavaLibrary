package com.jasonz.oop.collection;

import java.util.ArrayList;
import java.util.List;

import com.jasonz.oop.inheritance.base.BaseAnimal;
import com.jasonz.oop.inheritance.children.Elephant;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17
 * copywrite kkcms.com
 */
public class SampleList
{
	private List<BaseAnimal> myList = new ArrayList<BaseAnimal>();
	
	public void add()
	{
		Elephant obj = new Elephant();
		myList.add(obj);
	}
}

