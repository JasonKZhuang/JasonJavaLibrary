package com.jasonz.designpattern.structuralPatterns.bridge;

import com.jasonz.designpattern.structuralPatterns.bridge.painImageExample.*;

public class BridgeExampleMain {

    public BridgeExampleMain() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        AbstractImage image;
        IImageOperation imageOperation;

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
