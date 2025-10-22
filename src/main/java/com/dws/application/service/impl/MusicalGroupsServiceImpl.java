package com.dws.application.service.impl;

import com.dws.application.client.MusicalGroupsClient;
import com.dws.application.exception.ResourcesException;
import com.dws.application.model.MusicalGroupsDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.dws.application.service.MusicalGroupsService;

import java.util.List;

@Service
public class MusicalGroupsServiceImpl implements MusicalGroupsService {

    private final MusicalGroupsClient musicalGroupsClient;

    public MusicalGroupsServiceImpl(MusicalGroupsClient musicalGroupsClient) {
        this.musicalGroupsClient = musicalGroupsClient;
    }

    @Override
    @Cacheable(value = "groups")
    public Page<MusicalGroupsDTO> getAllMusicalGroups(Pageable pageable) {

        long totalElementos = 0;
        List<MusicalGroupsDTO> conteudoDaPagina = null;
        try {
            List<MusicalGroupsDTO> data = musicalGroupsClient.getAllMusicalGroups();
            totalElementos = data.size();
            int startIndex = (int) pageable.getOffset();
            int endIndex = Math.min((startIndex + pageable.getPageSize()), (int) totalElementos);

            conteudoDaPagina = data.subList(startIndex, endIndex);
        } catch (Exception e) {
            throw new ResourcesException(HttpStatus.NOT_FOUND, "List not found", "http://localhost:8080/api/v1/musical_groups");
        }

        return new PageImpl<>(conteudoDaPagina, pageable, totalElementos);
    }
}
