package creationalPatterns.builder.RobotExample;

public class RobotDirector
{
	private IRobotBuilder robotBuilder;
	
	public RobotDirector(IRobotBuilder robotBuilder)
	{
		this.robotBuilder = robotBuilder;
	}
	
	public Robot getRobot()
	{
		return this.robotBuilder.getRobot();
	}
	
	public void buildRobot()
	{
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotTorso();
		this.robotBuilder.buildRobotArms();
		this.robotBuilder.buildRobotLegs();
	}
}
