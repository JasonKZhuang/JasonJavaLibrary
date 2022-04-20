package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

public class QuickSortLib
{
	public int[] quickSort(int array[])
	{
		sort(array, 0, array.length - 1);
		return array;
	}

	private void sort(int array[], int p, int r)
	{
		int q = 0;
		if (p < r)
		{
			q = partition(array, p, r);
			sort(array, p, q - 1);
			sort(array, q + 1, r);
		}
	}

	private int partition(int[] a, int p, int r)
	{
		int x = a[r];
		int j = p - 1;
		for (int i = p; i <= r - 1; i++)
		{
			if (a[i] <= x)
			{
				j++;
				swap(a, j, i);
			}
		}
		swap(a, j + 1, r);
		return j + 1;
	}

	private void swap(int[] a, int i, int j)
	{
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
