package structuralPatterns.decorator;

import structuralPatterns.decorator.graphLibraryExample.ConcreteDecoratorBlackBorder;
import structuralPatterns.decorator.graphLibraryExample.ConcreteDecoratorScrollBar;
import structuralPatterns.decorator.graphLibraryExample.ListBox;
import structuralPatterns.decorator.graphLibraryExample.MyComponent;
import structuralPatterns.decorator.graphLibraryExample.TextBox;
import structuralPatterns.decorator.graphLibraryExample.Window;


public class DecoratorTestMain
{

	public static void main(String[] args)
	{
		MyComponent componentA,componentB,componentC;
		componentA = new Window();
		componentB = new ListBox();
		componentC = new TextBox();
		
		MyComponent componentDecoratroA,componentDecoratroB,componentDecoratroC;
		componentDecoratroA = new ConcreteDecoratorScrollBar(componentA);
		componentDecoratroA.display();
		System.out.println("==================================");
		componentDecoratroB = new ConcreteDecoratorScrollBar(componentB);
		componentDecoratroB.display();
		System.out.println("==================================");
		componentDecoratroC = new ConcreteDecoratorScrollBar(componentC);
		componentDecoratroC.display();
		System.out.println("==================================");
		MyComponent DecoratorTwoFuncs = new ConcreteDecoratorBlackBorder(componentDecoratroC);
		DecoratorTwoFuncs.display();
		System.out.println("==================================");
	}

}
