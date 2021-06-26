package com.thalesgroup.prueba.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    public Person(Long id, String firstName, String lastName, Long documentId, LocalDate birthDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentId = documentId;
        this.birthDate = birthDate;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true,nullable = false)
    private Long documentId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
}
