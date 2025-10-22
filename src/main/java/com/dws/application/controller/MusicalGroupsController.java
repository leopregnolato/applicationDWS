package com.dws.application.controller;

import com.dws.application.model.CustomPageResponseDTO;
import com.dws.application.model.MusicalGroupsDTO;
import com.dws.application.service.MusicalGroupsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/musical_groups")
public class MusicalGroupsController {

    private final MusicalGroupsService musicalGroupsService;

    public MusicalGroupsController(MusicalGroupsService musicalGroupsService) {
        this.musicalGroupsService = musicalGroupsService;
    }

    @GetMapping
    public ResponseEntity<CustomPageResponseDTO<MusicalGroupsDTO>> listarGrupos(Pageable pageable) {

        Page<MusicalGroupsDTO> gruposPage = musicalGroupsService.getAllMusicalGroups(pageable);
        CustomPageResponseDTO<MusicalGroupsDTO> responseDTO = new CustomPageResponseDTO<>(gruposPage);
        return ResponseEntity.ok(responseDTO);
    }
}
