package behavioralPatterns.Command;

public class TurnTVOn implements ICommand
{
	private IElectronicDevice theDevice;
	
	public TurnTVOn(IElectronicDevice newDevice)
	{
		this.theDevice = newDevice;
	}

	@Override
	public void execute()
	{
		theDevice.on();
	}

	@Override
	public void undo()
	{
		theDevice.off();
		
	}

}
