package com.jasonz.designpattern.structuralPatterns.proxy.PermissionProxy;

import lombok.Setter;

public class PermissionProxy implements AbstractPermission {

    private final RealPermission permission = new RealPermission();

    @Setter
    private int level = 0;

    public void modifyUserInfo() {
        if (0 == level) {
            System.out.println("the user's level is 0");
        } else if (1 == level) {
            permission.modifyUserInfo();
        }
    }

    public void viewNote() {
        System.out.println("view Note");
    }

    public void publishNote() {
        if (0 == level) {
            System.out.println("Level is Zero");
        } else if (1 == level) {
            permission.publishNote();
        }
    }

    public void modifyNote() {
        if (0 == level) {
            System.out.println("Level is Zero");
        } else if (1 == level) {
            permission.modifyNote();
        }
    }

}