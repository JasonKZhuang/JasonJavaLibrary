package creationalPatterns.FactoryMethod.LoggerExample;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtilLogger
{
	public static Object getBean()
	{
		try
		{
			// create DOM Object
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("configLogger.xml"));
			//
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue();
			cName = "creationalPatterns.FactoryMethod.LoggerExample."+ cName;
			// Create instance object by class name
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
