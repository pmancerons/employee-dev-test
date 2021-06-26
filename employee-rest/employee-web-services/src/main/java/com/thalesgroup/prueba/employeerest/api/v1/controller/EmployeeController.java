package com.thalesgroup.prueba.employeerest.api.v1.controller;

import com.thalesgroup.prueba.employeerest.api.v1.mappers.EmployeeMapper;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeDTO;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeListDTO;
import com.thalesgroup.prueba.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping({"/employees"})
    @ResponseStatus(HttpStatus.OK)
    public EmployeeListDTO getAllEmployees(){

        Set<EmployeeDTO> employeeListDTOS = new HashSet<>();
        employeeService.findAll().forEach(emp -> employeeListDTOS.add(employeeMapper.employeeToEmployeeDTO(emp)));

        return new EmployeeListDTO(employeeListDTOS);
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeMapper.employeeToEmployeeDTO(employeeService.findById(id));
    }

}
