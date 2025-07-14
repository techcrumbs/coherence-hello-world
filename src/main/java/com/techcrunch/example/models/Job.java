package com.techcrunch.example.models;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;

@Introspected
public class Job implements Serializable {

    private final String jobId;

    private final String reportingProjectId;

    private final String populationId;

    private final String resourcePrefix;

    private final String upstreamVersion;

    private final Long requestCount;

    public Job(String jobId, String reportingProjectId, String populationId, String resourcePrefix,
            String upstreamVersion, Long requestCount) {
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

    public String getReportingProjectId() {
        return reportingProjectId;
    }

    public String getPopulationId() {
        return populationId;
    }

    public String getResourcePrefix() {
        return resourcePrefix;
    }

    public String getUpstreamVersion() {
        return upstreamVersion;
    }

    public Long getRequestCount() {
        return requestCount;
    }

}
