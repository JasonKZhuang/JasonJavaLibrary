/*
 * Depend on abstractions, not on concretions
 * 
 * The principle of Dependency Inversion refers to the decoupling of software modules. 
 * This way, instead of high-level modules depending on low-level modules, 
 * both will depend on abstractions.
 * 
 * What does it mean that we should be having object of interface which helps us to 
 * communicate with the concrete classes. 
 * What do we gain from this is, we hide the actual implementation of class Lesson6Distinct from the class B.
 * So if class Lesson6Distinct changes the class B doesn’t need to care or know about the changes.
 */
package solid;

public class DependencyInversion
{
	private ILogger _logger;

	public DependencyInversion(ILogger _logger)
	{
		this._logger = _logger;
	}

	public static void main(String[] args)
	{
		MyDatabase db = new MyDatabase();
		DependencyInversion di1 = new DependencyInversion(new LoggerA());
		di1.CreateNewProduct(db, "some message!");
		
		
		DependencyInversion di2 = new DependencyInversion(new LoggerB());
		di2.CreateNewProduct(db, "some message!");
	}

	//
	public void CreateNewProduct(MyDatabase db, String postMessage)
	{
		try
		{
			db.add(postMessage);
		} catch (Exception ex)
		{
			this._logger.log(ex.getMessage());
			;
		}
	}

}

interface ILogger
{
	public void log(String msg);
}

class LoggerA implements ILogger
{

	@Override
	public void log(String msg)
	{
		System.out.println("This is LoggerAAAA log\n" + msg);
	}
}

class LoggerB implements ILogger
{
	@Override
	public void log(String msg)
	{
		System.out.println("This is LoggerBBBB log\n" + msg);
	}
}

class MyDatabase
{
	int i = 0;

	int j = 1;

	public void add(String msg)
	{
		j = j / i;
	}
}
