package creationalPatterns.builder.RobotExample;

public interface IRobotBuilder
{
	public void buildRobotHead();

	public void buildRobotTorso();

	public void buildRobotArms();

	public void buildRobotLegs();
	
	public Robot getRobot();
}
