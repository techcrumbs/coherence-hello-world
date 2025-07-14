package com.techcrunch.example.dao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record JobEntity(
        @Id @Column(name = "job_id") String jobId,
        @Column(name = "reporting_project_id") String reportingProjectId) {

}
