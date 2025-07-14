package com.techcrunch.example.models;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;

@Introspected
public record JobDto(String jobId, String reportingProjectId, String populationId, String resourcePrefix,
                     String upstreamVersion, Long requestCount) implements Serializable {
}
