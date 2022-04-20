package com.jasonz.designpattern.creationalPatterns.AbstractFactory.SkinExample;

/**
 * both factory and product are abstract (interface)
 * the method in the abstract factory will return abstract product
 */
public class ClientSkin
{
	public static void main(String args[])
	{
		// Using abstract Factory and abstract Object
		ISkinFactory factory;
		IButton bt;
		ITextField tf;
		IComboBox cb;

		//==========================//
		factory = new SkinFactorySummer(); 
		bt = factory.createButton();
		tf = factory.createTextField();
		cb = factory.createComboBox();

		bt.display();
		tf.display();
		cb.display();
		//==========================//
		factory = new SkinFactorySpring();
		bt = factory.createButton();
		tf = factory.createTextField();
		cb = factory.createComboBox();
		bt.display();
		tf.display();
		cb.display();
		
		//==========================//
		// factory = (ISkinFactory) XMLUtilSkin.getBean();
		// bt = factory.createButton();
		// tf = factory.createTextField();
		// cb = factory.createComboBox();
		// bt.display();
		// tf.display();
		// cb.display();
	}

}
