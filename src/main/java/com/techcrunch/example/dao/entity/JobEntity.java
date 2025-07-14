package com.techcrunch.example.dao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "jobs")
public class JobEntity {

        @Id
        @Column(name = "job_id")
        private String jobId;

        @Column(name = "reporting_project_id")
        private String reportingProjectId;

        @Column(name = "population_id")
        private String populationId;

        @Column(name = "resource_prefix")
        private String resourcePrefix;

        @Column(name = "upstream_version")
        private String upstreamVersion;

        @Column(name = "request_count")
        private Long requestCount;

        public JobEntity() {
                // no-arg constructor required for jpa
        }

        public JobEntity(String jobId, String reportingProjectId, String populationId,
                         String resourcePrefix, String upstreamVersion, Long requestCount) {
                this.jobId = jobId;
                this.reportingProjectId = reportingProjectId;
                this.populationId = populationId;
                this.resourcePrefix = resourcePrefix;
                this.upstreamVersion = upstreamVersion;
                this.requestCount = requestCount;
        }

        public String getJobId() {
                return jobId;
        }

        public void setJobId(String jobId) {
                this.jobId = jobId;
        }

        public String getReportingProjectId() {
                return reportingProjectId;
        }

        public void setReportingProjectId(String reportingProjectId) {
                this.reportingProjectId = reportingProjectId;
        }

        public String getPopulationId() {
                return populationId;
        }

        public void setPopulationId(String populationId) {
                this.populationId = populationId;
        }

        public String getResourcePrefix() {
                return resourcePrefix;
        }

        public void setResourcePrefix(String resourcePrefix) {
                this.resourcePrefix = resourcePrefix;
        }

        public String getUpstreamVersion() {
                return upstreamVersion;
        }

        public void setUpstreamVersion(String upstreamVersion) {
                this.upstreamVersion = upstreamVersion;
        }

        public Long getRequestCount() {
                return requestCount;
        }

        public void setRequestCount(Long requestCount) {
                this.requestCount = requestCount;
        }
}
