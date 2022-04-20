package creationalPatterns.builder.RobotExample;

public class TestRobotBuilder
{

	public TestRobotBuilder()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		IRobotBuilder oldStyleRobot = new OldRobotBuilder();
		RobotDirector robotDirector = new RobotDirector(oldStyleRobot);
		robotDirector.buildRobot();
		Robot oldRobot = robotDirector.getRobot();
		System.out.println("Robot Built");
		System.out.println("Robot Head Type:" +oldRobot.getRobotHead());
		System.out.println("Robot Torso Type:"+oldRobot.getRobotTorso());
		System.out.println("Robot Arms Type:" +oldRobot.getRobotArms());
		System.out.println("Robot Legs Type:" +oldRobot.getRobotLegs());
	}

}
