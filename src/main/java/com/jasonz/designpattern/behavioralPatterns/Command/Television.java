package behavioralPatterns.Command;

public class Television implements IElectronicDevice
{
	private int volume = 0;
	
	public Television()
	{
		;
	}

	@Override
	public void on()
	{
		System.out.println("TV is on.");
	}

	@Override
	public void off()
	{
		System.out.println("TV is off.");
	}

	@Override
	public void volumeUp()
	{
		volume ++;
		System.out.println("TV Volume is at " + volume);
	}

	@Override
	public void volumeDown()
	{
		volume --;
		System.out.println("TV Volume is at " + volume);
	}

}
