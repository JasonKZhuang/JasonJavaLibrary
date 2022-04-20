package structuralPatterns.composite.antiVirusExample;

public abstract class AbstractFileComponent
{
	public abstract void add(AbstractFileComponent file);
	
	public abstract void remove(AbstractFileComponent file);
	
	public abstract AbstractFileComponent getChild(int i);
	
	public abstract void killVirus();
}
