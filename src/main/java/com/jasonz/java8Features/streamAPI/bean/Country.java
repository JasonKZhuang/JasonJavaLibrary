package com.jasonz.java8Features.streamAPI.bean;

import lombok.Data;

@Data
public class Country {
    private String countryCode;
    private String description;
    private CityList cityList;
}
