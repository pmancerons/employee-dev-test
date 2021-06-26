package com.thalesgroup.prueba.employeerest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListDTO {
    private Set<EmployeeDTO> employees;
}
