package com.thalesgroup.prueba.employeerest.api.v1.mappers.bussines;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class SalaryCalculation {

    public static BigDecimal calculateYearSalary(BigDecimal  monthlySalary){
        log.debug("calculating year salary");
        return monthlySalary.multiply(BigDecimal.valueOf(12));
    }
}
