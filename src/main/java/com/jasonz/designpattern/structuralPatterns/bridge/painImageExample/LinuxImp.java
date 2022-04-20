package structuralPatterns.bridge.painImageExample;

public class LinuxImp implements IImageOperation
{

	public LinuxImp()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doPaint(Matrix m)
	{
		// TODO Auto-generated method stub
		System.out.println("Display Image in Linux OS.");
	}

}
