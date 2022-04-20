package creationalPatterns.builder.RobotExample;

public class OldRobotBuilder implements IRobotBuilder
{
	private Robot robot;
	
	public OldRobotBuilder()
	{
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead()
	{
		robot.setRobotHead("Tin head");
	}

	@Override
	public void buildRobotTorso()
	{
		robot.setRobotTorso("Steal torso");
	}

	@Override
	public void buildRobotArms()
	{
		robot.setRobotArms("Wooden arms");
	}

	@Override
	public void buildRobotLegs()
	{
		robot.setRobotLegs("Gold legs");
	}

	@Override
	public Robot getRobot()
	{
		return this.robot;
	}

}
