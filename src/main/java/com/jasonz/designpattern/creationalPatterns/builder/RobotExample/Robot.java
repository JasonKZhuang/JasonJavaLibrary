package creationalPatterns.builder.RobotExample;

public class Robot implements IRobotPlan
{
	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;
	
	public Robot()
	{
		;
	}

	@Override
	public void setRobotHead(String head)
	{
		this.robotHead = head;
	}

	@Override
	public void setRobotTorso(String torso)
	{
		this.robotTorso = torso;
	}

	@Override
	public void setRobotArms(String arms)
	{
		this.robotArms = arms;
	}

	@Override
	public void setRobotLegs(String legs)
	{
		this.robotLegs = legs;
	}

	public String getRobotHead()
	{
		return robotHead;
	}

	public String getRobotTorso()
	{
		return robotTorso;
	}

	public String getRobotArms()
	{
		return robotArms;
	}

	public String getRobotLegs()
	{
		return robotLegs;
	}

}
