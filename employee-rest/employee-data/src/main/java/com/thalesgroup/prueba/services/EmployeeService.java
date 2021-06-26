package com.thalesgroup.prueba.services;

import com.thalesgroup.prueba.data.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService extends CrudService<Employee,Long> {

    Employee findByLastName(String lastName);

    Employee findByDocumentId(Long documentId);
}
