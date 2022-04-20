package creationalPatterns.builder.RobotExample;

public interface IRobotPlan
{
	public void setRobotHead(String head);
	
	public void setRobotTorso(String torso);
	
	public void setRobotArms(String arms);
	
	public void setRobotLegs(String legs);
}
