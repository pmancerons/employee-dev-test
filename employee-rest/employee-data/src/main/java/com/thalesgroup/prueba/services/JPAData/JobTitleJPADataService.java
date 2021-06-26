package com.thalesgroup.prueba.services.JPAData;

import com.thalesgroup.prueba.data.JobTitle;
import com.thalesgroup.prueba.repositories.JobTitleRepository;
import com.thalesgroup.prueba.services.JobTitleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JobTitleJPADataService implements JobTitleService {

    private final JobTitleRepository jobTitleRepository;

    public JobTitleJPADataService(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    @Override
    public Set<JobTitle> findAll() {
        Set<JobTitle> jobTitles = new HashSet<>();

        jobTitleRepository.findAll().forEach(jobTitles::add);

        return jobTitles;
    }

    @Override
    public JobTitle findById(Long id) {
        return jobTitleRepository.findById(id).orElse(null);
    }

    @Override
    public JobTitle save(JobTitle jobTitle) {
        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public void delete(JobTitle jobTitle) {
        jobTitleRepository.delete(jobTitle);
    }

    @Override
    public void deleteById(Long id) {
        jobTitleRepository.deleteById(id);
    }
}
