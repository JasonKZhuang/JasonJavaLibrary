package com.jasonz.designpattern.structuralPatterns.facade;

import com.jasonz.designpattern.structuralPatterns.facade.dealwithLegacyCode.FacadeUserService;
import com.jasonz.designpattern.structuralPatterns.facade.example.GeneralSwitchFacade;
import com.jasonz.designpattern.structuralPatterns.facade.example.IFacade;
import com.jasonz.designpattern.structuralPatterns.facade.example.SwitchFacade;

public class FacadeExampleMain {

    public static void main(String[] args) {
        FacadeUserService facadeUserService = new FacadeUserService();
        facadeUserService.login("john_doe", "password123");

    }

    private void otherFacadeHandler() {
        GeneralSwitchFacade gsf = new GeneralSwitchFacade();
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