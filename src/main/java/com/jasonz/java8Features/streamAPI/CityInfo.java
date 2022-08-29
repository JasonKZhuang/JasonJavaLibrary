package com.jasonz.java8Features.streamAPI;

import lombok.Data;

import java.util.List;
@Data
public class CityInfo {

    private int id;

    private String name;

    private List<OfficeInfo> offices;
}