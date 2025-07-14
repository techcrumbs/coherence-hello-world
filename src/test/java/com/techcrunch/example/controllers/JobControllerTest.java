package com.techcrunch.example.controllers;


import com.techcrunch.example.models.Job;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@MicronautTest
public class JobControllerTest {

  @Inject
  @Client("/my-service")
  HttpClient client;

  @Test
  public void testPostAndGet() {
    Job requestJob = new Job(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
            "testPrefix", "testVersion", 10L);
    HttpRequest<Job> postReq = HttpRequest.POST("/jobs", requestJob);
    HttpResponse<Job> postResp = client.toBlocking().exchange(postReq, Job.class);

    Assertions.assertEquals(201, postResp.code());

    Job fetchedJob =  client.toBlocking().retrieve("/jobs/" + requestJob.jobId(), Job.class);
    Assertions.assertNotNull(fetchedJob);
    Assertions.assertEquals(requestJob, fetchedJob);
  }
}
