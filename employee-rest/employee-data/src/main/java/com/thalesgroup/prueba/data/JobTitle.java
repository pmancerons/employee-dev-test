package com.thalesgroup.prueba.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_titles")
public class JobTitle extends BaseEntity{

    @Builder
    public JobTitle(Long id, String name, String jobDescription) {
        super(id);
        this.jobTitleName = name;
        this.jobDescription = jobDescription;
    }

    @Column(name = "name")
    private String jobTitleName;
    private String jobDescription;

    public String toString(){
        return jobTitleName + " : " + jobDescription;
    }
}
