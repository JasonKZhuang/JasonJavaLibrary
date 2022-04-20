package com.jasonz.designpattern.creationalPatterns.AbstractFactory.SkinExample;

public class SkinFactorySpring implements ISkinFactory
{

	public IButton createButton()
	{
		return new ButtonSpring();
	}

	public ITextField createTextField()
	{
		return new TextFieldSpring();
	}

	public IComboBox createComboBox()
	{
		return new ComboBoxSpring();
	}

}
