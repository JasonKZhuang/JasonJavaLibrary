package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

public class ConcreteAdapter extends AbstractAdapter
{

	QuickSortLib quickSort = null;
	
	public ConcreteAdapter()
	{
		this.quickSort = new QuickSortLib();
	}

	@Override
	public int[] sort(int[] array)
	{
		// TODO Auto-generated method stub
		return quickSort.quickSort(array);
	}
	
}
