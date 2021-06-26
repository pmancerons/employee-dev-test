package com.thalesgroup.prueba.services.JPAData;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.repositories.EmployeeRepository;
import com.thalesgroup.prueba.repositories.JobTitleRepository;
import com.thalesgroup.prueba.services.EmployeeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class EmployeeJPADataService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeJPADataService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public Employee findByDocumentId(Long documentId) {
        return employeeRepository.findByDocumentId(documentId);
    }

    @Override
    public Set<Employee> findAll() {
        Set<Employee> employees = new HashSet<>();

        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
