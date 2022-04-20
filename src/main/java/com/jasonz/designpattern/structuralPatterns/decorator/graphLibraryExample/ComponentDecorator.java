package structuralPatterns.decorator.graphLibraryExample;

public abstract class ComponentDecorator extends MyComponent
{
	private MyComponent component;
	
	public ComponentDecorator(MyComponent component)
	{
		this.component = component;
	}
	
	@Override
	public void display()
	{
		this.component.display();
	}

}
