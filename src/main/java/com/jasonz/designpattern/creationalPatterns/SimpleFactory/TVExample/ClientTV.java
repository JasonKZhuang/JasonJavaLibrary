package com.jasonz.designpattern.creationalPatterns.SimpleFactory.TVExample;

import com.jasonz.designpattern.creationalPatterns.SimpleFactory.TVExample.ITV;
import com.jasonz.designpattern.creationalPatterns.SimpleFactory.TVExample.TVSimpleFactory;
import creationalPatterns.SimpleFactory.TVExample.XMLUtilTV;

public class ClientTV {

    public static void main(String args[]) {
        try {
            ITV tv;
            String brandName = XMLUtilTV.getBrandName();
            tv = TVSimpleFactory.produceTV(brandName);
            tv.play();

            //
            tv = TVSimpleFactory.produceTV("TCL");
            tv.play();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
