package com.thalesgroup.prueba.employeerest.api.v1.controller;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.employeerest.api.v1.exceptions.NotFoundException;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.EmployeeMapper;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeDTO;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeListDTO;
import com.thalesgroup.prueba.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping({"/employees"})
    @ResponseStatus(HttpStatus.OK)
    public EmployeeListDTO getAllEmployees(){

        log.info("in employees endpoint");

        Set<EmployeeDTO> employeeListDTOS = new HashSet<>();
        Set<Employee> employees = employeeService.findAll();

        if(employees.isEmpty()){
            log.info("there are no employees");
            throw new NotFoundException("there are no employees");
        }

        employees.forEach(emp -> employeeListDTOS.add(employeeMapper.employeeToEmployeeDTO(emp)));

        return new EmployeeListDTO(employeeListDTOS);
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        log.info("in employee/id endpoint");

        Employee emp = employeeService.findById(id);

        if(emp == null){
            log.info("there are no employee with the id: " + id);
            throw new NotFoundException("The id has not been found");
        }
        return employeeMapper.employeeToEmployeeDTO(emp);
    }

}
