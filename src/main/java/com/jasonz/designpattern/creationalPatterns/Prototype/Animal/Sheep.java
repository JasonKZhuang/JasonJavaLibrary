package creationalPatterns.Prototype.Animal;

public class Sheep implements IAnimal
{
	public Sheep()
	{
		System.out.println("Sheep is made.");
	}
	@Override
	public IAnimal makeCopy()
	{
		System.out.println("Sheep is being made.");
		Sheep sheepObject = null;
		try
		{
			sheepObject = (Sheep) super.clone();
		}catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return sheepObject;
	}
	
	public String toString()
	{
		return "Jason is my Hero.";
	}

}
