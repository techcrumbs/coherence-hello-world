package com.techcrunch.example.dao.repository;


import com.techcrunch.example.dao.entity.JobEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface JobRepository extends CrudRepository<JobEntity, String> {

}
