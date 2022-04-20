package structuralPatterns.facade.example;

public class Light
{
	private String position;
	
	public Light(String position)
	{
		this.position=position;	
	}
	
	public void on()
	{
		System.out.println(this.position + " open the light");
	}
	
	public void off()
	{
		System.out.println(this.position + " close the light");	
	}
	
	public void step1()
	{
		;	
	}
	
	public void step2()
	{
		;	
	}
}