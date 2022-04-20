package com.jasonz.designpattern.creationalPatterns.AbstractFactory.SkinExample;

public interface ISkinFactory
{
	public IButton createButton();
	
	public ITextField createTextField();
	
	public IComboBox createComboBox();
}
