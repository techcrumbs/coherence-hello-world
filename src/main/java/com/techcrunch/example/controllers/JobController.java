package com.techcrunch.example.controllers;

import java.util.Optional;

import com.techcrunch.example.models.Job;
import com.techcrunch.example.services.JobService;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

@Controller("/jobs")
public class JobController {
    
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @Get(uri = "/{jobId}", produces = MediaType.APPLICATION_JSON)
    public Optional<Job> getUser(String jobId) {
        return jobService.findById(jobId);
    }

    @Post(uri = "/", produces = MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    public Job createUser(@Body Job user) {
        return jobService.save(user);
    }
}
