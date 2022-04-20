/**
 * 
 */
package com.jasonz.designpattern.structuralPatterns.adapter.algExample;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Apr 23, 2018
 * ScoreOperation.java
 * Describe:
 */
public interface IScoreOperation
{
	/**
	 * sort the score
	 * @param array
	 * @return
	 */
	public int[] sort(int array[]);
	
	/**
	 * find 
	 * @param array
	 * @param key
	 * @return
	 */
	public int search(int array[],int key);
	
}
