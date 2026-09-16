package com.example.PcBuildingWeb.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalProductService {

    private final RestClient restClient;

    @Value("${pc.api.url}")
    private String apiUrl;

    public ExternalProductService() {
        this.restClient = RestClient.create();
    }

    public String getProducts() {

        return restClient
                .get()
                .uri(apiUrl)
                .retrieve()
                .body(String.class);
    }
}