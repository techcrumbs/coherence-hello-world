package com.techcrunch.example.cachestores.transformer;

import com.techcrunch.example.dao.entity.JobEntity;
import com.techcrunch.example.models.JobDto;

public class JobDtoEntityTransformer implements DtoEntryTransformer<JobDto, JobEntity>{
  @Override
  public JobDto toDtoFromEntity(JobEntity jobEntity) {
    return new JobDto(jobEntity.getJobId(), jobEntity.getReportingProjectId(), jobEntity.getPopulationId(),
            jobEntity.getResourcePrefix(), jobEntity.getUpstreamVersion(), jobEntity.getRequestCount());
  }

  @Override
  public JobEntity toEntityFromDto(JobDto jobDto) {
    return new JobEntity(jobDto.jobId(), jobDto.reportingProjectId(), jobDto.populationId(),
            jobDto.resourcePrefix(), jobDto.upstreamVersion(), jobDto.requestCount());
  }
}
