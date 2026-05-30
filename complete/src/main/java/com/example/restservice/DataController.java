package com.example.restservice;

import com.example.restservice.client.DataRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class DataController {

    private final RestClient restClient;

    public DataController() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:3000")
            .build();
    }

    @GetMapping("/datarc")
    public DataRecord getData() {
        return restClient.get()
            .uri("/data")
            .retrieve()
            .body(DataRecord.class);
    }
}