package com.thalesgroup.prueba.employeerest.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private BigDecimal yearSalary;
    private String jobTitleName;
}
