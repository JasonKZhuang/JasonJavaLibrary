/*
 * Clients should not be forced to implement unnecessary methods which they will not use
 * 
 * The best place to look for IPS examples is Java AWT event handlers 
 * for handling GUI events fired from keyboard and mouse. 
 * It has different listener classes for each kind of event. 
 * We only need to write handlers for events, we wish to handle. Nothing is mandatory.
 * 
 * Some of the listeners are –
 * 	FocusListener
 * 	KeyListener
 * 	MouseMotionListener
 * 	MouseWheelListener
 * 	TextListener
 * 	WindowFocusListener
 */

package solid;

public class InterfaceSegregation
{

	public static void main(String[] args)
	{
		MyClass myClass = new MyClass();
		myClass.doSomething();
		myClass.doSomethingKey();
		myClass.doSomethingMouse();
	}
}

class MyClass implements MyKeyListener, MyMouseMotionListener
{

	@Override
	public void doSomething()
	{
		System.out.println("Do something in My Class");
	}

	@Override
	public void doSomethingMouse()
	{
		System.out.println("Monitoring Mouse!");
		
	}

	@Override
	public void doSomethingKey()
	{
		System.out.println("Monitoring Keys!");
		
	}
	
}



interface MyKeyListener
{
	public void doSomething();
	public void doSomethingKey();
}

interface MyMouseMotionListener
{
	public void doSomething();
	public void doSomethingMouse();
}

interface MyWindowFocusListener
{
	public void doSomething();
	public void doSomethingWindow();
}


