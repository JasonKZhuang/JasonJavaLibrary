package structuralPatterns.facade.example;

public class SwitchFacade implements IFacade
{

	private Light lights[]=new Light[4];
	private Fan fan;
	private AirConditioner ac;
	private Television tv;
	
	public SwitchFacade()
	{
		lights[0]=new Light("AAAA");
		lights[1]=new Light("BBBB");
		fan=new Fan();
		ac=new AirConditioner();
		tv=new Television();
	}

	@Override
	public void on()
	{
		lights[0].on();
		lights[1].on();
		fan.on();
		ac.on();
		tv.on();

	}

	@Override
	public void off()
	{
		lights[0].off();
		lights[1].off();
		fan.off();
		ac.off();
		tv.off();

	}

	@Override
	public void attack()
	{
		// TODO Auto-generated method stub
		lights[0].step1();
		lights[0].step2();
		
	}

}
