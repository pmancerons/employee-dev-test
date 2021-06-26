package com.thalesgroup.prueba.employeerest.api.v1.controller;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.data.JobTitle;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.EmployeeMapperDecorator;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.EmployeeMapperImpl;
import com.thalesgroup.prueba.employeerest.api.v1.mappers.EmployeeMapperImpl_;
import com.thalesgroup.prueba.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.hamcrest.Matchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    EmployeeMapperDecorator employeeMapperDecorator = new EmployeeMapperImpl();

    @Mock
    EmployeeService employeeService;

    EmployeeController employeeController;

    MockMvc mockMvcEmployeeController;

    @BeforeEach
    void setUp() {
        employeeMapperDecorator.setEmployeeMapper( new EmployeeMapperImpl_());
        employeeController = new EmployeeController(employeeService,employeeMapperDecorator);
        mockMvcEmployeeController = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void getAllEmployees() throws Exception {

        JobTitle dev = JobTitle.builder()
                .jobTitleName("dev")
                .jobDescription("The one who writes code")
                .build();

        JobTitle tester = JobTitle.builder()
                .jobTitleName("tester")
                .jobDescription("The one makes dev angry ")
                .build();

        Employee devEmp = Employee.builder()
                .birthDate(LocalDate.of(1990,12,21))
                .documentId(1022333666l)
                .startDate(LocalDate.of(2021,8,1))
                .salary(BigDecimal.valueOf(8000000.0))
                .firstName("dev")
                .lastName("1")
                .jobTitle(dev)
                .build();

        Employee testEmp = Employee.builder()
                .birthDate(LocalDate.of(1990,12,21))
                .documentId(1022666333l)
                .startDate(LocalDate.of(2021,8,1))
                .salary(BigDecimal.valueOf(1000000.0))
                .firstName("test")
                .lastName("1")
                .jobTitle(tester)
                .build();

        Set<Employee> employeeList = new HashSet<>();

        employeeList.add(devEmp);
        employeeList.add(testEmp);

        Mockito.when(employeeService.findAll()).thenReturn(employeeList);

        mockMvcEmployeeController.perform(MockMvcRequestBuilders.get("/api/v1/employees")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees",Matchers.hasSize(2)));
    }

    @Test
    void getEmployeeById() throws Exception {

        JobTitle dev = JobTitle.builder()
                .jobTitleName("dev")
                .jobDescription("The one who writes code")
                .build();

        Employee devEmp = Employee.builder()
                .birthDate(LocalDate.of(1990,12,21))
                .documentId(1022333666l)
                .startDate(LocalDate.of(2021,8,1))
                .salary(BigDecimal.valueOf(8000000.0))
                .firstName("dev")
                .lastName("1")
                .jobTitle(dev)
                .build();

        Mockito.when(employeeService.findById(ArgumentMatchers.anyLong())).thenReturn(devEmp);

        mockMvcEmployeeController.perform(MockMvcRequestBuilders.get("/api/v1/employee/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.equalTo("dev")));
    }
}