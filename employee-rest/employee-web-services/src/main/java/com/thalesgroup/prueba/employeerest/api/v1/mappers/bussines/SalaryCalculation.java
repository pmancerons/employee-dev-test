package com.thalesgroup.prueba.employeerest.api.v1.mappers.bussines;

import java.math.BigDecimal;

public class SalaryCalculation {

    public static BigDecimal calculateYearSalary(BigDecimal  monthlySalary){
        return monthlySalary.multiply(BigDecimal.valueOf(12));
    }
}
