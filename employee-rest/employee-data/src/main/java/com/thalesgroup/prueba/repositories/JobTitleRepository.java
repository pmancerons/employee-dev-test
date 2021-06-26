package com.thalesgroup.prueba.repositories;

import com.thalesgroup.prueba.data.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle,Long> {
}
