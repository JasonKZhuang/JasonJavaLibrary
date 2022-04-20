package creationalPatterns.builder.ActorExample;

public class AngelBuilder extends AbstractActorBuilder
{
	public AngelBuilder()
	{
		super();
	}

	public void buildType()
	{
		actorProdoct.setType("天使");
	}

	public void buildSex()
	{
		actorProdoct.setSex("女");
	}

	public void buildFace()
	{
		actorProdoct.setFace("漂亮");
	}

	public void buildCostume()
	{
		actorProdoct.setCostume("白裙");
	}

	public void buildHairstyle()
	{
		actorProdoct.setHairstyle("披肩长发");
	}

}
