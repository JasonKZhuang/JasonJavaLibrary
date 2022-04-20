package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

public class ClassAdapter extends QuickSortLib implements IScoreOperation
{
	private BinarySearchLib binSearch;
	
	public ClassAdapter()
	{
		this.binSearch = new BinarySearchLib();
	}

	@Override
	public int[] sort(int[] array)
	{
		return this.quickSort(array);
		
	}

	@Override
	public int search(int[] array, int key)
	{
		return this.binSearch.search(array, key);
	}

}
