package com.jasonz.java8Features.optional;

public class Address
{
	private String streetNo;
	private Country country;

    public Address(String streetNo, Country country) {
        this.streetNo = streetNo;
        this.country = country;
    }

    public String getStreetNo()
	{
		return streetNo;
	}

	public void setStreetNo(String streetNo)
	{
		this.streetNo = streetNo;
	}

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}

}
