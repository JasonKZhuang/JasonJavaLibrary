/**
 * Derived types must be completely substitutable for their base types.
 * This requires the objects of your subclasses to behave in the same way as the objects of your superclass. 
 */
package solid;

public class LiskovSubstitution
{

	public static void main(String[] args)
	{
		EmailSender es = new EmailSenderImpl();
		
		Customer obj1 = new VIPCustomer();
		es.send(obj1);
		
		Customer obj2 = new CommonCustomer();
		es.send(obj2);
				

	}

}

interface EmailSender
{
	public void send(Customer obj);
}


class EmailSenderImpl implements EmailSender
{

	@Override
	public void send(Customer obj)
	{
		System.out.println("Name:"+ obj.getName() + "  Email:" + obj.getEmailAddress());
	}
	
}

class VIPCustomer extends Customer 
{
	public VIPCustomer()
	{
		this.setName("VIPJason");
		this.setEmailAddress("VIPJason@gmail.com");
	}
}

class CommonCustomer extends Customer 
{
	public CommonCustomer()
	{
		this.setName("CommonJason");
		this.setEmailAddress("CommonJason@gmail.com");
	}
}

class Customer
{
	private String name;
	private String emailAddress;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
}
