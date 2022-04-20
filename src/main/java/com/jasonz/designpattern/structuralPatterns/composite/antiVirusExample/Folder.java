package structuralPatterns.composite.antiVirusExample;

import java.util.ArrayList;

public class Folder extends AbstractFileComponent
{
	//定义集合fileList，用于存储AbstractFileComponent类型的成员
	private ArrayList<AbstractFileComponent> fileList=new ArrayList<AbstractFileComponent>();
	
	private String name;
	
	public Folder(String name) 
	{
		this.name = name;
	}
	
	public void add(AbstractFileComponent file)
	{
		fileList.add(file);
	}

	public void remove(AbstractFileComponent file)
	{
		fileList.remove(file);
		
	}

	public AbstractFileComponent getChild(int i)
	{
		// TODO Auto-generated method stub
		return (AbstractFileComponent)fileList.get(i);
	}

	public void killVirus()
	{
		// TODO Auto-generated method stub
		System.out.println("****对文件夹'" + name + "'进行杀毒"); //模拟杀毒
		
		//递归调用成员构件的killVirus()方法
		for(Object obj : fileList) 
		{
			((AbstractFileComponent)obj).killVirus();
		}
	}

}
