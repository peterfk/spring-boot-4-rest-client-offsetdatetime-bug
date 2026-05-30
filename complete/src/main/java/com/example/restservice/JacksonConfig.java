package com.example.restservice;

// Source - https://stackoverflow.com/a/79948281
// Posted by Josue Paniagua, modified by community. See post 'Timeline' for change history
// Retrieved 2026-05-29, License - CC BY-SA 4.0

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

@Configuration
public class JacksonConfig {

//    @Bean
//    @Primary
//    public ObjectMapper myObjectMapper() {
//        return JsonMapper.builder()
//            .disable(DateTimeFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
//            .disable(DateTimeFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE)
//            .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
//            .build();
//    }
}


