package com.thalesgroup.prueba.employeerest.preload;

import com.thalesgroup.prueba.data.Employee;
import com.thalesgroup.prueba.data.JobTitle;
import com.thalesgroup.prueba.services.EmployeeService;
import com.thalesgroup.prueba.services.JobTitleService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final JobTitleService jobTitleService;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        JobTitle techLead = JobTitle.builder()
                .jobTitleName("Tech Lead")
                .jobDescription("Dev group leader")
                .build();

        JobTitle dev = JobTitle.builder()
                .jobTitleName("dev")
                .jobDescription("The one who writes code")
                .build();

        JobTitle tester = JobTitle.builder()
                .jobTitleName("tester")
                .jobDescription("The one makes dev angry ")
                .build();

        jobTitleService.save(techLead);
        jobTitleService.save(dev);
        jobTitleService.save(tester);

        Employee pedro = Employee.builder()
                .birthDate(LocalDate.of(1990,12,21))
                .documentId(1022333666l)
                .startDate(LocalDate.of(2021,8,1))
                .salary(BigDecimal.valueOf(8000000.0))
                .firstName("Pedro")
                .lastName("Ceron")
                .jobTitle(dev)
                .build();


        Employee test = Employee.builder()
                .birthDate(LocalDate.of(1990,12,21))
                .documentId(1022666333l)
                .startDate(LocalDate.of(2021,8,1))
                .salary(BigDecimal.valueOf(8000000.0))
                .firstName("test")
                .lastName("1")
                .jobTitle(tester)
                .build();

        employeeService.save(pedro);
        employeeService.save(test);
    }
}
