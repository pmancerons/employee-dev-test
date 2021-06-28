package com.thalesgroup.prueba.employeerest.api.v1.mappers;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.bussines.SalaryCalculation;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Slf4j
public abstract class EmployeeMapperDecorator implements EmployeeMapper{

    private EmployeeMapper employeeMapper;

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO employeeToEmployeeDTO(Employee source){
        log.debug("Mapping employee to DTO");

        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(source);

        employeeDTO.setJobTitleName(source.getJobTitle().getJobTitleName());
        employeeDTO.setYearSalary(SalaryCalculation.calculateYearSalary(source.getSalary()));

        return employeeDTO;
    }
}
