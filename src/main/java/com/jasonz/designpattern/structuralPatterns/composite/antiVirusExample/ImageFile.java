package structuralPatterns.composite.antiVirusExample;

public class ImageFile extends AbstractFileComponent
{

	private String name;
	
	public ImageFile(String fileName)
	{
		this.name = fileName;
	}
	
	public void add(AbstractFileComponent file)
	{
		System.out.println("对不起，不支持该方法！");

	}

	public void remove(AbstractFileComponent file)
	{
		System.out.println("对不起，不支持该方法！");

	}

	public AbstractFileComponent getChild(int i)
	{
		System.out.println("对不起，不支持该方法！");
		return null;
	}

	public void killVirus()
	{
		System.out.println("----对图像文件'" + name + "'进行杀毒");
	}

}
