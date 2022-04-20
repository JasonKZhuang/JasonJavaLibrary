package creationalPatterns.builder.ActorExample;

public class HeroBuilder extends AbstractActorBuilder
{
	public HeroBuilder()
	{
		super();
	}
	
	public void buildType()
	{
		actorProdoct.setType("英雄");
	}

	public void buildSex()
	{
		actorProdoct.setSex("男");
	}

	public void buildFace()
	{
		actorProdoct.setFace("英俊");
	}

	public void buildCostume()
	{
		actorProdoct.setCostume("盔甲");
	}

	public void buildHairstyle()
	{
		actorProdoct.setHairstyle("飘逸");
	}

}
