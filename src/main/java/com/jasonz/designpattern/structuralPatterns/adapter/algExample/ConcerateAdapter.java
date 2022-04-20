package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

public class ConcerateAdapter extends AbstractAdapter
{

	QuickSortLib quickSort = null;
	
	public ConcerateAdapter()
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
