package structuralPatterns.bridge;

import structuralPatterns.bridge.painImageExample.AbstractImage;
import structuralPatterns.bridge.painImageExample.BMPImage;
import structuralPatterns.bridge.painImageExample.IImageOperation;
import structuralPatterns.bridge.painImageExample.JPGImage;
import structuralPatterns.bridge.painImageExample.LinuxImp;
import structuralPatterns.bridge.painImageExample.WindowsImpl;

public class BridgeExampleMain
{

	public BridgeExampleMain()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		AbstractImage image;
		IImageOperation imageOperation ;
		
		image = new BMPImage();
		imageOperation = new LinuxImp();
		image.setImageOperation(imageOperation);
		image.parseFile("Star War.");
		
		
		image = new JPGImage();
		imageOperation = new WindowsImpl();
		image.setImageOperation(imageOperation);
		image.parseFile("Star War.");
		
		
	}

}
