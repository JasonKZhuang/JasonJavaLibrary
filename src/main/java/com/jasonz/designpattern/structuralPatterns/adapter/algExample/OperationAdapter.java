package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

public class OperationAdapter implements IScoreOperation
{

	private QuickSortLib quickSort = null;
	
	private BinarySearchLib binarySearch = null;
	
	public OperationAdapter()
	{
		this.quickSort =  new QuickSortLib();
		this.binarySearch = new BinarySearchLib();
	}
	
	public OperationAdapter(QuickSortLib quickSort,BinarySearchLib binarySearch)
	{
		// TODO Auto-generated constructor stub
		this.quickSort = quickSort;
		this.binarySearch = binarySearch;
	}

	@Override
	public int[] sort(int[] array)
	{
		return this.quickSort.quickSort(array);
	}

	@Override
	public int search(int[] array, int key)
	{
		return this.binarySearch.search(array, key);
	}

}
