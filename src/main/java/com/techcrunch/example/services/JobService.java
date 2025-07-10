package com.techcrunch.example.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.techcrunch.example.models.Job;

import jakarta.inject.Singleton;

@Singleton
public class JobService {

    private final Map<String, Job> store = new HashMap<>();
    
    public Job save(Job job) {
        store.put(job.getJobId(), job);
        return job;
    }

    public Optional<Job> findById(String jobId) {
        return Optional.ofNullable(store.get(jobId));
    }
}
