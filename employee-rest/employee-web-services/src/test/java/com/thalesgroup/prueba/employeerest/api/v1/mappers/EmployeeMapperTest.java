package com.thalesgroup.prueba.employeerest.api.v1.mappers;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.data.JobTitle;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.bussines.SalaryCalculation;
import com.thalesgroup.prueba.employeerest.api.v1.model.EmployeeDTO;
import com.thalesgroup.prueba.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    EmployeeMapperDecorator employeeMapperDecorator = new EmployeeMapperImpl();

    @BeforeEach
    void setUp() throws MalformedURLException {
        employeeMapperDecorator.setEmployeeMapper( new EmployeeMapperImpl_());
    }

    @Test
    void employeeToEmployeeDTO() {
        JobTitle dev = JobTitle.builder()
                .jobTitleName("dev")
                .build();

        Employee employee = Employee.builder()
                .salary(BigDecimal.valueOf(8000000.0))
                .firstName("Pedro")
                .lastName("Ceron")
                .jobTitle(dev)
                .build();

        EmployeeDTO mappedEmployee = employeeMapperDecorator.employeeToEmployeeDTO(employee);

        assertEquals(employee.getFirstName(),mappedEmployee.getFirstName());
        assertEquals(employee.getLastName(),mappedEmployee.getLastName());
        assertEquals(SalaryCalculation.calculateYearSalary(employee.getSalary()),mappedEmployee.getYearSalary());
        assertEquals(employee.getJobTitle().getJobTitleName(),mappedEmployee.getJobTitleName());
    }
}