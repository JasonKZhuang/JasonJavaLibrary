package com.jasonz.java8Features.streamAPI.bean;

import lombok.Data;

import java.util.List;

@Data
public class CityList {
    private List<CityInfo> cities;
}