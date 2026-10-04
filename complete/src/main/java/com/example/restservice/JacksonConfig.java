package com.example.restservice;

// Source - https://stackoverflow.com/a/79948281
// Posted by Josue Paniagua, modified by community. See post 'Timeline' for change history
// Retrieved 2026-05-29, License - CC BY-SA 4.0

import com.example.restservice.client.DataClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.JacksonJsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

@Configuration
public class JacksonConfig {

//    @Bean
//    @Primary
//    public JsonMapper jacksonJsonMapperXXX() {
//        return JsonMapper.builder()
//            .disable(DateTimeFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
//            .disable(DateTimeFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE)
//            .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
//            .build();
//    }

//    @Bean
//    public DataClient dataClient(JsonMapper jsonMapper) {
//        JsonMapper customMapper = jsonMapper.rebuild()
//            .disable(DateTimeFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
//            .build();
//        RestClient restClient = RestClient.builder()
//            .baseUrl("http://localhost:3000")
//            .messageConverters(converters -> {
//                converters.removeIf(c -> c instanceof JacksonJsonHttpMessageConverter);
//                converters.add(new JacksonJsonHttpMessageConverter(customMapper));
//            })
//            .build();
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//            .builderFor(RestClientAdapter.create(restClient))
//            .build();
//        return factory.createClient(DataClient.class);
//    }

//    @Bean
//    public DataClient dataClient2(JsonMapper jsonMapper) {
//        JsonMapper customMapper = jsonMapper.rebuild()
//            .disable(DateTimeFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
//            .build();
//
//        RestClient restClient = RestClient.builder()
//            .baseUrl("http://localhost:3000")
//            .configureMessageConverters(builder -> builder
//                .withJsonConverter(new JacksonJsonHttpMessageConverter(customMapper))
//            )
//            .build();
//
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//            .builderFor(RestClientAdapter.create(restClient))
//            .build();
//        return factory.createClient(DataClient.class);
//    }

}


