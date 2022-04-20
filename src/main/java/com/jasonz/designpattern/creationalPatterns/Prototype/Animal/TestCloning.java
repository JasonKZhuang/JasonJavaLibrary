package creationalPatterns.Prototype.Animal;

public class TestCloning
{
	public static void main(String[] args)
	{
		Sheep sally = new Sheep();
		CloneFactory factory = new CloneFactory();
		Sheep clonedSheep = (Sheep) factory.getClone(sally);
		System.out.println(sally.toString());
		System.out.println(clonedSheep.toString());
		System.out.println("Sally Hashcode:" + System.identityHashCode(sally));
		System.out.println("Sally Hashcode:" + System.identityHashCode(sally));
		System.out.println("clonedSheep Hashcode:" + System.identityHashCode(clonedSheep));
	}
}
