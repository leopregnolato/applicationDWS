package com.dws.application.service;

import com.dws.application.model.MusicalGroupsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicalGroupsService {

    public Page<MusicalGroupsDTO> getAllMusicalGroups(Pageable pageable);

}
