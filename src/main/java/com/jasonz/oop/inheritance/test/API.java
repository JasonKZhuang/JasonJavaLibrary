package com.jasonz.oop.inheritance.test;

public abstract class API
{
	public abstract void checkValue(Object value) throws IllegalArgumentException;
	
	public boolean isValueANumber(Object val)
	{
		if (val instanceof  Number)
		{
			
			return true;
		}else
		{
			try {
				Double.parseDouble(val.toString());
				return true;
			}catch(NumberFormatException exp)
			{
				return false;
			}
		}
	}
}