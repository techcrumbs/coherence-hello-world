package com.techcrunch.example.services;

import java.util.Optional;

import com.tangosol.net.NamedCache;
import com.techcrunch.example.models.JobDto;

import io.micronaut.coherence.annotation.Name;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class JobService {

    @Inject
    @Name("jobCache")
    private NamedCache<String, JobDto> jobCache;
    
    public JobDto save(JobDto job) {
        jobCache.put(job.jobId(), job);
        return job;
    }

    public Optional<JobDto> findById(String jobId) {
        return Optional.ofNullable(jobCache.get(jobId));
    }
}
