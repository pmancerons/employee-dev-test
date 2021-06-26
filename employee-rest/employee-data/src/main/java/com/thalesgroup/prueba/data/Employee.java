package com.thalesgroup.prueba.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee extends Person{

    @Builder
    public Employee(Long id, String firstName, String lastName, Long documentId, LocalDate birthDate, LocalDate startDate, LocalDate endDate, BigDecimal salary, JobTitle jobTitle) {
        super(id, firstName, lastName, documentId, birthDate);
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal  salary;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;
}
