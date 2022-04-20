package com.jasonz.designpattern.creationalPatterns.FactoryMethod.TVExample;

public class HisenseTVFactory implements TVFactory
{
	public ITV produceTV()
	{
		System.out.println("���ŵ��ӻ������������ŵ��ӻ���");
		return new HisenseTV();
	}
}