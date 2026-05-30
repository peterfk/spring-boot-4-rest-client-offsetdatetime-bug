package com.example.restservice;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.client.DataClient;
import com.example.restservice.client.DataRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.DeserializationConfig;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationConfig;
import tools.jackson.databind.cfg.DatatypeFeatures;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private String json = """
        {"id":1,"content":"Hello, test!","createdAt":"2026-04-19T08:30:00-04:00"}
        """;

    @Autowired
    private JsonMapper mapper;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/data")
    public DataRecord getData() {
        return dataClient.getData();
    }


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.ofHours(-4));

        // 3. Specific date and time
        OffsetDateTime specific = OffsetDateTime.of(2026, 4, 19,
            8, 30, 0, 0, ZoneOffset.of("-04:00"));

        Greeting codeGreeting = new Greeting(counter.incrementAndGet(), template.formatted(name), specific);

        Greeting parseGreeting = mapper.readValue(json, Greeting.class);

        System.out.println(parseGreeting);

        for (DateTimeFeature feature : DateTimeFeature.values()) {
            System.out.println(feature + ": " + mapper.isEnabled(feature));
        }

        return parseGreeting;
    }


    @PostConstruct
    public void init() {
        System.out.println("Mapper class: " + mapper.getClass().getName());
        System.out.println("Mapper config: " + mapper.serializationConfig());
        System.out.println("Deserialization config: " + mapper.deserializationConfig());
        System.out.println("Serialization config: " + mapper);
        SerializationConfig config = mapper.serializationConfig();
        DeserializationConfig deserializationConfig = mapper.deserializationConfig();
        DatatypeFeatures datatypeFeatures = deserializationConfig.getDatatypeFeatures();
//        datatypeFeatures.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("ADJUST_DATES_TO_CONTEXT_TIME_ZONE: " +
            mapper.isEnabled(DateTimeFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE));
        int i = 10;
    }
}
