package com.techcrunch.example.cachestores;

import com.tangosol.net.cache.CacheStore;
import com.techcrunch.example.dao.repository.JobRepository;
import com.techcrunch.example.models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobStore implements CacheStore<String, Job> {

  private final JobRepository jobRepository;

  private static final Logger logger = LoggerFactory.getLogger(JobStore.class);

  public JobStore(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public void store(String key, Job job) {
    logger.info("Insert job: {} to DB", job);
  }

  @Override
  public void erase(String key) {
    logger.info("Delete job with id: {} from DB", key);
  }

  @Override
  public Job load(String key) {
    logger.info("Load job with id: {} from DB", key);
    return null;
  }
}
