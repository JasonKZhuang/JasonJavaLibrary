package com.jasonz.designpattern.structuralPatterns.proxy.dealwithLegacy;

public class ProxyDataAccessObject extends LegacyDataAccessObject {

    private final LegacyDataAccessObject dao;

    public ProxyDataAccessObject() {
        this.dao = new LegacyDataAccessObject();
    }

    @Override
    public void fetchData() {
        System.out.println("Logging: Fetching data in Proxy Layer");
        dao.fetchData();
    }
}
