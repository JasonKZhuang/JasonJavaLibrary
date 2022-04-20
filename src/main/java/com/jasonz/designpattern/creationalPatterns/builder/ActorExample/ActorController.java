package creationalPatterns.builder.ActorExample;


/**
 * @author Jason.Zhuang
 * @studentId s3535252 Apr 11, 2018 ActorController.java Describe: it plays
 *            Director role
 */
public class ActorController
{
	// 逐步构建复杂产品对象
	public ActorProdoct constructProduct(AbstractActorBuilder builder)
	{
		ActorProdoct actor;
		builder.buildType();
		builder.buildSex();
		builder.buildFace();
		builder.buildCostume();
		builder.buildHairstyle();
		actor = builder.createActor();
		return actor;
	}
}
