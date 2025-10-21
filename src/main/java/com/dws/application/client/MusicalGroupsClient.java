package com.dws.application.client;


import com.dws.application.model.MusicalGroupsDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
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

    public List<MusicalGroupsDTO> buscarProdutosPaginados(int page, int size, String sort) {

        ParameterizedTypeReference<List<MusicalGroupsDTO>> responseType =
                new ParameterizedTypeReference<List<MusicalGroupsDTO>>() {};

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(baseUrl)
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .queryParam("sort", sort)
                        .build())
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }
}
