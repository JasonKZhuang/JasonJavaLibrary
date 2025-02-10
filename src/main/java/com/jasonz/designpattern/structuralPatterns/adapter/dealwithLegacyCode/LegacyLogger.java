package com.jasonz.designpattern.structuralPatterns.adapter.dealwithLegacyCode;

public class LegacyLogger {
    public void logMessage(String message) {
        System.out.println("Legacy Log: " + message);
    }
}