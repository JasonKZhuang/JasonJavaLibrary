package com.jasonz.designpattern.creationalPatterns.builder.ActorExample;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Apr 11, 2018
 * ActorBuilder.java
 * Describe: This is the abstract Builder
 */
public abstract class AbstractActorBuilder {
    protected ActorProdoct actorProdoct = new ActorProdoct();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    //工厂方法，返回一个完整的游戏角色对象
    public ActorProdoct createActor() {
        return actorProdoct;
    }

}
