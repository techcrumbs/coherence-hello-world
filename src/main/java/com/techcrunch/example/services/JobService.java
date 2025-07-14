package com.techcrunch.example.services;

import java.util.Optional;

import com.tangosol.net.NamedCache;
import com.techcrunch.example.models.Job;

import io.micronaut.coherence.annotation.Name;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class JobService {

    @Inject
    @Name("jobCache")
    private NamedCache<String, Job> jobCache;
    
    public Job save(Job job) {
        jobCache.put(job.jobId(), job);
        return job;
    }

    public Optional<Job> findById(String jobId) {
        return Optional.ofNullable(jobCache.get(jobId));
    }
}
