package behavioralPatterns.Observer;

public abstract class IObserver
{

	public IObserver()
	{
		// TODO Auto-generated constructor stub
	}

	public abstract void update(double ibmPrice, double applePrice,
			double googPrice);
}
