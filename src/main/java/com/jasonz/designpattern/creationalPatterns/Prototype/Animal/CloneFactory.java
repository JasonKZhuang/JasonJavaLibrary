package creationalPatterns.Prototype.Animal;

public class CloneFactory
{
	public IAnimal getClone(IAnimal animal)
	{
		return animal.makeCopy();
	}
}
