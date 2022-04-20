package com.jasonz.designpattern.creationalPatterns.AbstractFactory.SkinExample;

public class SkinFactorySummer implements ISkinFactory
{

	public IButton createButton()
	{
		return new ButtonSummer();
	}

	public ITextField createTextField()
	{
		return new TextFieldSummer();
	}

	public IComboBox createComboBox()
	{
		return new ComboBoxSummer();
	}

}
