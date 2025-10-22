package com.dws.application.client;


import com.dws.application.model.MusicalGroupsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class MusicalGroupsClient {

    @Value("${api.bands-api-url}")
    private String baseUrl;

    private final WebClient webClient;


    public MusicalGroupsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public List<MusicalGroupsDTO> getAllMusicalGroups() {

        ParameterizedTypeReference<List<MusicalGroupsDTO>> responseType =
                new ParameterizedTypeReference<List<MusicalGroupsDTO>>() {};

            return this.webClient.get()
                    .uri(baseUrl)
                    .retrieve()
                    .bodyToFlux(responseType)
                .blockFirst();
    }
}
