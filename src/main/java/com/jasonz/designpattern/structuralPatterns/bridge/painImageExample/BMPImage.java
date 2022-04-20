package structuralPatterns.bridge.painImageExample;

public class BMPImage extends AbstractImage
{

	public BMPImage()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseFile(String fileName)
	{
		// TODO Auto-generated method stub
		Matrix m = new Matrix();
		this.imageOperation.doPaint(m);
		System.out.println(fileName + "BMP file.");
	}

}
