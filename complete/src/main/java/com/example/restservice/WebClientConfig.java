package com.example.restservice;

import com.example.restservice.client.DataClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.service.registry.ImportHttpServices;
import tools.jackson.databind.ObjectMapper;

@Configuration
@ImportHttpServices(group = "data-api")
public class WebClientConfig {

//    @Bean
//    public WebClientHttpServiceGroupConfigurer dataApiConfigurer(ObjectMapper objectMapper) {
//        return groups -> groups
//            .filterByName("data-api")
//            .forEachClient((name, builder) -> builder
//                .codecs(configurer -> {
//                    configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
//                    configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
//                })
//            );
//    }
}
