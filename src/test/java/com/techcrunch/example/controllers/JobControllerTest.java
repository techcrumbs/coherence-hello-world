package com.techcrunch.example.controllers;

import com.techcrunch.example.Application;
import com.techcrunch.example.cachestores.AppCacheStoreFactory;
import com.techcrunch.example.models.JobDto;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.UUID;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JobControllerTest {

  @Inject
  ApplicationContext ctx;

  @Inject
  @Client("/my-service")
  HttpClient client;

  @BeforeAll
  void setupOnce() {
    AppCacheStoreFactory.init(ctx);
  }

  @Test
  public void testPostAndGet() {
    JobDto requestJob = new JobDto(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
            "testPrefix", "testVersion", 10L);
    HttpRequest<JobDto> postReq = HttpRequest.POST("/jobs", requestJob);
    HttpResponse<JobDto> postResp = client.toBlocking().exchange(postReq, JobDto.class);

    Assertions.assertEquals(201, postResp.code());

    JobDto fetchedJob =  client.toBlocking().retrieve("/jobs/" + requestJob.jobId(), JobDto.class);
    Assertions.assertNotNull(fetchedJob);
    Assertions.assertEquals(requestJob, fetchedJob);
  }
}
