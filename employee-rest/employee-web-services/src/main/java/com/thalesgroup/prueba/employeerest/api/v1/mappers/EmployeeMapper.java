package com.thalesgroup.prueba.employeerest.api.v1.mappers;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(EmployeeMapperDecorator.class)
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
}
