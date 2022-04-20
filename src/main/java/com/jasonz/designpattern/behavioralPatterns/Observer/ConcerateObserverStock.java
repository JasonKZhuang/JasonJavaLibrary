package behavioralPatterns.Observer;


public class ConcerateObserverStock extends IObserver
{
	private double ibmPrice;
	private double applePrice;
	private double googlePrice;
	
	private static int observerIDTracker = 0;
	
	private int observerID;
	
	private ISubject stockGrabber;
	
	public ConcerateObserverStock(ISubject stockGrabber)
	{
		this.stockGrabber = stockGrabber;
		this.observerID = ++observerIDTracker;
		System.out.println("\nNew Observer  "+ this.observerID);
		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double applePrice, double googPrice)
	{
		this.ibmPrice = ibmPrice;
		this.applePrice = applePrice;
		this.googlePrice = googPrice;
		printThePrice();
	}
	
	private void printThePrice()
	{
		System.out.println("\nObserver ID:"+observerID
				+"\nIBM:"+ibmPrice
				+"\nApple:"+applePrice
				+"\nGoogle:"+googlePrice);
	}
}
