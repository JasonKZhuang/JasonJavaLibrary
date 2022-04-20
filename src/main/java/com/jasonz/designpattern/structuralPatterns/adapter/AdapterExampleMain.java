package com.jasonz.designpattern.structuralPatterns.adapter;

import com.jasonz.designpattern.structuralPatterns.adapter.algExample.ClassAdapter;
import com.jasonz.designpattern.structuralPatterns.adapter.algExample.ConcerateAdapter;
import com.jasonz.designpattern.structuralPatterns.adapter.algExample.IScoreOperation;
import com.jasonz.designpattern.structuralPatterns.adapter.algExample.OperationAdapter;

public class AdapterExampleMain
{

	public AdapterExampleMain()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		// Programming to the interface of abstract Target
		// this is property adapter
		IScoreOperation operation = new OperationAdapter();
		int scores1[] = { 84, 76, 50, 69, 90, 91, 88, 96 };
		int result[];
		int score;
		System.out.println("======================================");
		System.out.println("This is an example of using Property Adapter:");
		System.out.print("The original result：");
		for (int i : scores1)
		{
			System.out.print(i + ",");
		}
		System.out.println("");
		System.out.print("The sorted   result：");
		result = operation.sort(scores1);
		// literating the score
		for (int i : scores1)
		{
			System.out.print(i + ",");
		}
		System.out.println();

		System.out.println("Find the score=90：");
		score = operation.search(result, 90);
		if (score != -1)
		{
			System.out.println("Got the 90.");
		} else
		{
			System.out.println("Did not get 90.");
		}
		System.out.println("Find the score=92：");
		score = operation.search(result, 92);
		if (score != -1)
		{
			System.out.println("Got the 92.");
		} else
		{
			System.out.println("Did not get 92.");
		}
		
		//this is called "class adpter" example
		System.out.println("======================================");
		System.out.println("This is an example of using Class Adapter:");
		int scores2[] = { 77, 33, 22, 87, 11, 24, 56, 9 };
		System.out.print("The original result：");
		for (int i : scores2)
		{
			System.out.print(i + ",");
		}
		System.out.println("");
		ClassAdapter classAdapter = new ClassAdapter();
		classAdapter.sort(scores2);
		System.out.print("The sorted   result：");
		// literating the score
		for (int i : scores2)
		{
			System.out.print(i + ",");
		}
		
		
		//this is called "default adapter" example
		System.out.println("\n======================================");
		System.out.println("This is an example of using Default Adapter:");
		int scores3[] = { 77, 33, 22, 87, 11, 24, 56, 9 };
		System.out.print("The original result：");
		for (int i : scores3)
		{
			System.out.print(i + ",");
		}
		System.out.println("");
		ConcerateAdapter concAdp = new ConcerateAdapter();
		result = concAdp.sort(scores3);
		System.out.print("The sorted   result：");
		// literating the score
		for (int i : scores3)
		{
			System.out.print(i + ",");
		}
	}

}
