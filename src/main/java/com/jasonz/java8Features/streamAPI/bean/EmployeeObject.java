package com.jasonz.java8Features.streamAPI.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class EmployeeObject {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean isPermanent;
}
