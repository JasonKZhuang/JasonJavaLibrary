package com.jasonz.java8Features.streamAPI;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OfficeInfo {
    private int id;
    private String name;
    private String code;
    private String timezoneInfoId;
}