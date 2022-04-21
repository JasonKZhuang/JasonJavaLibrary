package com.jasonz.designpattern.creationalPatterns.builder.ActorExample;

public class DevilBuilder extends AbstractActorBuilder
{
	public DevilBuilder()
	{
		super();
	}
	
	public void buildType()
	{
		actorProdoct.setType("恶魔");
	}

	public void buildSex()
	{
		actorProdoct.setSex("妖");
	}

	public void buildFace()
	{
		actorProdoct.setFace("丑陋");
	}

	public void buildCostume()
	{
		actorProdoct.setCostume("黑衣");
	}

	public void buildHairstyle()
	{
		actorProdoct.setHairstyle("光头");
	}

}
