package behavioralPatterns.Command;

public class TurnVolumeUp implements ICommand
{
	private IElectronicDevice theDevice;
	
	public TurnVolumeUp(IElectronicDevice newDevice)
	{
		this.theDevice = newDevice;
	}

	@Override
	public void execute()
	{
		theDevice.volumeUp();
	}

	@Override
	public void undo()
	{
		theDevice.volumeDown();
		
	}

}
