package structuralPatterns.proxy.PermissionProxy;

public class RealPermission implements AbstractPermission
{	
	public void modifyUserInfo()
	{
		System.out.println("Modify User's information.");
	}

	public void viewNote()
	{   
		
	}
	
	public void publishNote()
	{
		System.out.println("Publishing Note");
	}
	
	public void modifyNote()
	{
		System.out.println("Modify Note");
	}
	
	public void setLevel(int level)
	{	
		
	}
}