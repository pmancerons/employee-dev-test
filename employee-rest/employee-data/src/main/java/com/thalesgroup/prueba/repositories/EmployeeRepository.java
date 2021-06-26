package com.thalesgroup.prueba.repositories;

import com.thalesgroup.prueba.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByLastName(String lastName);

    Employee findByDocumentId(Long documentId);
}
