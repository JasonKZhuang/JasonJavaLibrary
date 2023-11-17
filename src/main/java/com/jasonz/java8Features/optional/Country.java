package com.jasonz.java8Features.optional;

public class Country
{
	private String isoCode;

    public Country(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getIsoCode()
	{
		return isoCode;
	}

	public void setIsoCode(String isoCode)
	{
		this.isoCode = isoCode;
	}

}
