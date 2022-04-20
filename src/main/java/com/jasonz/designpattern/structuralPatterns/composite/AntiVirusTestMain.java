package structuralPatterns.composite;

import structuralPatterns.composite.antiVirusExample.AbstractFileComponent;
import structuralPatterns.composite.antiVirusExample.Folder;
import structuralPatterns.composite.antiVirusExample.ImageFile;
import structuralPatterns.composite.antiVirusExample.TextFile;
import structuralPatterns.composite.antiVirusExample.VideoFile;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Apr 18, 2018
 * CompositePatternTestMain.java
 * Describe:
 * 组合模式(Composite Pattern)：
 * 组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。
 * 组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性，
 * 组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。
 * 在组合模式中引入了抽象构件类Component，它是所有容器类和叶子类的公共父类，
 * 客户端针对Component进行编程.
 * 
 * 在组合模式结构图中包含如下几个角色：
 * ●Component（抽象构件）：它可以是接口或抽象类，为叶子构件和容器构件对象声明接口，
 * 在该角色中可以包含所有子类共有行为的声明和实现。
 * 在抽象构件中定义了访问及管理它的子构件的方法，如增加子构件、删除子构件、获取子构件等.
 * ●Leaf（叶子构件）：它在组合结构中表示叶子节点对象，叶子节点没有子节点，它实现了在抽象构件中定义的行为。
 * 对于那些访问及管理子构件的方法，可以通过异常等方式进行处理。
 * ● Composite（容器构件）：它在组合结构中表示容器节点对象，容器节点包含子节点，
 * 其子节点可以是叶子节点，也可以是容器节点，
 * 它提供一个集合用于存储子节点，实现了在抽象构件中定义的行为，
 * 包括那些访问及管理子构件的方法，在其业务方法中可以递归调用其子节点的业务方法。
 * 
 * 组合模式的关键是定义了一个抽象构件类，它既可以代表叶子，又可以代表容器，
 * 而客户端针对该抽象构件类进行编程，无须知道它到底表示的是叶子还是容器，可以对其进行统一处理。
 * 同时容器对象与抽象构件类之间还建立一个聚合关联关系，在容器对象中既可以包含叶子，也可以包含容器，
 * 以此实现递归组合，形成一个树形结构。
 * 
 * 如果不使用组合模式，客户端代码将过多地依赖于容器对象复杂的内部实现结构，
 * 容器对象内部实现结构的变化将引起客户代码的频繁变化，带来了代码维护复杂、可扩展性差等弊端。
 * 组合模式的引入将在一定程度上解决这些问题
 * 
 */
public class AntiVirusTestMain
{

	/**
	 * 由于在本实例中使用了组合模式，在抽象构件类中声明了所有方法，包括用于管理和访问子构件的方法，
	 * 如add()方法和remove()方法等，
	 * 因此在ImageFile等叶子构件类中实现这些方法时必须进行相应的异常处理或错误提示。
	 * 在容器构件类Folder的killVirus()方法中将递归调用其成员对象的killVirus()方法，
	 * 从而实现对整个树形结构的遍历。
	 * 如果需要更换操作节点，例如只需对文件夹“文本文件”进行杀毒，客户端代码只需修改一行即可.
	 * change folder1.killVirus(); 
	 * to 
	 * folder3.killVirus();
	 */
	public static void main(String[] args)
	{
		//针对抽象构件编程
		AbstractFileComponent file1  ,file2  ,file3  ,file4  ,file5;
		AbstractFileComponent parentFolder,folder2,folder3,folder4;
		
		parentFolder = new Folder("Sunny的资料");
		folder2 = new Folder("图像文件");
		folder3 = new Folder("文本文件");
		folder4 = new Folder("视频文件");
		
		file1 = new ImageFile("小龙女.jpg");
		file2 = new ImageFile("张无忌.gif");
		file3 = new TextFile("九阴真经.txt");
		file4 = new TextFile("葵花宝典.doc");
		file5 = new VideoFile("笑傲江湖.rmvb");
		
		folder2.add(file1);
		folder2.add(file2);
		folder3.add(file3);
		folder3.add(file4);
		folder4.add(file5);
		
		parentFolder.add(folder2);
		parentFolder.add(folder3);
		parentFolder.add(folder4);
		
		//从“Sunny的资料”节点开始进行杀毒操作
		parentFolder.killVirus();

		
	}

}
