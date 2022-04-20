package structuralPatterns.decorator.graphLibraryExample;

public class ConcreteDecoratorBlackBorder extends ComponentDecorator
{

	public ConcreteDecoratorBlackBorder(MyComponent component)
	{
		super(component);
	}

	@Override
	public void display()
	{
		this.setBlackBorder();
		super.display();
	}
	
	public void setBlackBorder()
	{
		System.out.println("Adding Black Border.");
	}

}
