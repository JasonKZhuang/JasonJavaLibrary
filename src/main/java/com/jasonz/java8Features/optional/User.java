package com.jasonz.java8Features.optional;

public class User {
    private String name;
    private String email;
    private String password;
    private Address address;

    public User() {
        super();
    }

    public User(String name) {
        this.name = name;
    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
