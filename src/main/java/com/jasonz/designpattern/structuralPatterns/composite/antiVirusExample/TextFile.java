
package com.jasonz.designpattern.structuralPatterns.composite.antiVirusExample;

public class TextFile extends AbstractFileComponent
{

	private String name;
	
	public TextFile(String fileName)
	{
		this.name = fileName;
	}
	
	public void add(AbstractFileComponent file)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");

	}

	public void remove(AbstractFileComponent file)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");

	}

	public AbstractFileComponent getChild(int i)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");
		return null;
	}

	public void killVirus()
	{
		System.out.println("----��ͼ���ļ�'" + name + "'����ɱ��");
	}

}

