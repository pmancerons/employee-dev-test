package com.thalesgroup.prueba.services.JPAData;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeJPADataServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeJPADataService employeeJPADataService;


    @Test
    void findByLastName(){
        Employee returnEmployee = Employee.builder().id(1l).lastName("Ceron").build();

        when(employeeRepository.findByLastName(eq("Ceron"))).thenReturn(returnEmployee);

        assertEquals(1l,employeeJPADataService.findByLastName("Ceron").getId());
    }

    @Test
    void findByDocumentId(){
        Employee returnEmployee = Employee.builder().id(1l).documentId(1022333666l).build();

        when(employeeRepository.findByDocumentId(eq(1022333666l))).thenReturn(returnEmployee);

        assertEquals(1l,employeeJPADataService.findByDocumentId(1022333666l).getId());
    }

    @Test
    void findAll() {
        List<Employee> employeesReturn = new ArrayList<>();
        Employee employee1 = Employee.builder().id(1l).lastName("Ceron").build();
        Employee employee2 = Employee.builder().id(2l).lastName("Ceron2").build();

        employeesReturn.add(employee1);
        employeesReturn.add(employee2);

        when(employeeRepository.findAll()).thenReturn(employeesReturn);
        Set<Employee> ownersFound = employeeJPADataService.findAll();

        assertEquals(2,ownersFound.size());
    }

    @Test
    void findById() {
        Employee returnEmployee = Employee.builder().id(1l).lastName("Ceron").build();

        when(employeeRepository.findById(eq(1l))).thenReturn(Optional.of(returnEmployee));

        assertEquals("Ceron",employeeJPADataService.findById(1l).getLastName());

    }


    @Test
    void findByIdDoesNotExist() {

        when(employeeRepository.findById(eq(1l))).thenReturn(Optional.empty());

        assertNull(employeeJPADataService.findById(1l));

    }

    @Test
    void save() {
        Employee returnEmployee = Employee.builder().id(1l).lastName("Ceron").build();

        when(employeeRepository.save(returnEmployee)).thenReturn(returnEmployee);

        assertEquals(returnEmployee,employeeJPADataService.save(returnEmployee));
    }

    @Test
    void delete() {
        Employee returnOwner = Employee.builder().id(1l).lastName("Ceron").build();

        employeeJPADataService.delete(returnOwner);

        verify(employeeRepository).delete(any());
    }

    @Test
    void deleteById() {
        employeeJPADataService.deleteById(1l);

        verify(employeeRepository).deleteById(any());
    }
}