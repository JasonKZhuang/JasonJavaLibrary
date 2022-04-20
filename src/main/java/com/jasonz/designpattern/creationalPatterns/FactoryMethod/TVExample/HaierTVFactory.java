package com.jasonz.designpattern.creationalPatterns.FactoryMethod.TVExample;

public class HaierTVFactory implements TVFactory
{
    public ITV produceTV()
    {
    	System.out.println("�������ӻ����������������ӻ���");
    	return new HaierTV();
    }
}