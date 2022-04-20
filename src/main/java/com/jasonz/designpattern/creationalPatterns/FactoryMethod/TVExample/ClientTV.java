package com.jasonz.designpattern.creationalPatterns.FactoryMethod.TVExample;

public class ClientTV {
    public static void main(String args[]) {
        try {
            ITV tv;
            TVFactory factory = (TVFactory) XMLUtil.getBean();
            tv = factory.produceTV();
            tv.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
