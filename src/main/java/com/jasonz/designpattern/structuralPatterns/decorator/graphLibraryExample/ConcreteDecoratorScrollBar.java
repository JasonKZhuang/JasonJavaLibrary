package structuralPatterns.decorator.graphLibraryExample;

public class ConcreteDecoratorScrollBar extends ComponentDecorator
{

	public ConcreteDecoratorScrollBar(MyComponent component)
	{
		super(component);
	}
	
	@Override
	public void display()
	{
		this.setScrollBar();
		super.display();
	}
	
	public void setScrollBar()
	{
		System.out.println("Adding Scroll Bar.");
	}

}
