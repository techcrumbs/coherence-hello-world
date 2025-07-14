package com.techcrunch.example.cachestores;

import com.tangosol.net.cache.CacheStore;
import com.techcrunch.example.cachestores.transformer.JobDtoEntityTransformer;
import com.techcrunch.example.dao.entity.JobEntity;
import com.techcrunch.example.dao.repository.JobRepository;
import com.techcrunch.example.models.JobDto;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@Singleton
public class JobStore implements CacheStore<String, JobDto> {

  private final JobRepository jobRepository;

  private final EntityManager entityManager;

  private final JobDtoEntityTransformer transformer = new JobDtoEntityTransformer();

  private static final Logger logger = LoggerFactory.getLogger(JobStore.class);

  public JobStore(JobRepository jobRepository, EntityManager entityManager) {
    this.jobRepository = jobRepository;
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void store(String key, JobDto job) {
    logger.info("Insert job: {} to DB", job);
//    jobRepository.save(transformer.toEntityFromDto(job));
    entityManager.merge(transformer.toEntityFromDto(job));
  }

  @Override
  public void erase(String key) {
    logger.info("Delete job with id: {} from DB", key);
    jobRepository.deleteById(key);
  }

  @Override
  public JobDto load(String key) {
    logger.info("Load job with id: {} from DB", key);
    Optional<JobEntity> optionalJobEntity = jobRepository.findById(key);
    return optionalJobEntity.map(transformer::toDtoFromEntity).orElse(null);
  }
}
