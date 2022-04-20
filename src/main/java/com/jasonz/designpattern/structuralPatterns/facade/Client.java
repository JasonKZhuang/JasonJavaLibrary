package structuralPatterns.facade;

import structuralPatterns.facade.example.GeneralSwitchFacade;
import structuralPatterns.facade.example.IFacade;
import structuralPatterns.facade.example.SwitchFacade;

public class Client
{
	public static void main(String args[])
	{
		GeneralSwitchFacade gsf=new GeneralSwitchFacade();
		gsf.on();
		System.out.println("-----------------------");	
		gsf.off();
		
		System.out.println("--------using interface---------------");	
		IFacade facade = new SwitchFacade();
		facade.on();
		System.out.println("-----------------------");	
		facade.off();
	}
}