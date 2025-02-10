package com.jasonz.designpattern.structuralPatterns.facade.dealwithLegacyCode;

public class LegacyUserProfile {
    public void loadProfile(String username) {
        // Complex profile loading logic
        System.out.println("Profile loaded for " + username);
    }
}
