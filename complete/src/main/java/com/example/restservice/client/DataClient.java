package com.example.restservice.client;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "http://localhost:3000")
public interface DataClient {

    @GetExchange("/data")
    DataRecord getData();
}
