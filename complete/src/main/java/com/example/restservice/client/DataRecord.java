package com.example.restservice.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record DataRecord(
    @JsonProperty("id") Long id,
    @JsonProperty("content") String content,
    @JsonFormat(without = JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, with = {})
    @JsonProperty("createdAt") OffsetDateTime createdAt,
    @JsonProperty("createdAt2") OffsetDateTime createdAt2
) {}