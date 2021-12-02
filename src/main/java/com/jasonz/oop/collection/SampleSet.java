package com.jasonz.oop.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17 copywrite
 */
public class SampleSet
{
	public static void main(String[] args)
	{
		SampleSet ss = new SampleSet();
//		ss.testingTreeSet();
//		ss.testingHashMap();
		ss.testingArrayList();
	}
	private void testingArrayList()
	{
		List<String> lst = new ArrayList<>();
		for (int i=1;i<100;i++)
		{
			if (lst.contains("book"))
			{
				System.out.println("book is existing");
			}else
			{
				lst.add("book");
			}
		}
	}
	private void testingHashSet()
	{
		// Set 集合存和取的顺序不一致。
		Set<String> hs = new HashSet<String>();
		try
		{
			hs.add("世界军事");
			hs.add("兵器知识");
			hs.add("舰船知识");
			hs.add("汉和防务");
			hs.add("汉和防务");
			System.out.println(hs);
			// [舰船知识, 世界军事, 兵器知识, 汉和防务]
			Iterator<String> it = hs.iterator();
			while (it.hasNext())
			{
				System.out.println(it.next());
			}
		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	private void testingTreeSet()
	{
		// Set 集合存和取的顺序不一致。
		Set<String> hs = new TreeSet<String>();
		try
		{
			hs.add("hello");
			hs.add("Jason");
			hs.add("Jason");
			Iterator<String> it = hs.iterator();
			while (it.hasNext())
			{
				System.out.println(it.next());
			}
		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	private void testingHashMap()
	{
		// Set 集合存和取的顺序不一致。
		Map<String,String> myMap = new HashMap<>();
		try
		{
			myMap.put("hello", "hello");
			myMap.put("Jason", "Jason");
			myMap.put("hello", "hello");
			Iterator<String> it = myMap.keySet().iterator();
			while (it.hasNext())
			{
				System.out.println(it.next());
			}
		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
}
