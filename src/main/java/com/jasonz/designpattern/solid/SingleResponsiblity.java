/**
 * SingleResponsiblity
 * A class should only have a single responsibility
 * A class should have one and only one reason to change, 
 * meaning that a class should have only one job.
 * Reference: 
 * https://howtodoinjava.com/best-practices/5-class-design-principles-solid-in-java/
 */
package solid;

import java.util.List;

/**
 * we have two classes Person and Account. 
 * Both have single responsibility to store their specific information. 
 * If we want to change state of Person,
 * then we do not need to modify the class Account 
 * Moreover, in person class, we don't do db operation,
 * instead we define a new class to handle the db save or delete
 */
public class SingleResponsiblity
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	class Person
	{
		private Long personId;
	    private String firstName;
	    private String lastName;
	    private String age;
	    //
	    private List<Account> accounts;
	    private PersonDao dao;
	}
	
	class Account
	{
		private Long accountId;
	    private String accountNumber;
	    private String accountName;
	    private String status;
	    private String type;
	}
	
	class PersonDao
	{
		public void save()
		{
			;
		}
		public void delete()
		{
			;
		}
	}

}
