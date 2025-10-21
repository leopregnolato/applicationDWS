package com.dws.application.service.impl;

import com.dws.application.model.MusicalGroupsDTO;
import org.springframework.stereotype.Service;
import com.dws.application.service.MusicalGroupsService;

import java.util.List;

@Service
public class MusicalGroupsServiceImpl implements MusicalGroupsService {

    @Override
    public List<MusicalGroupsDTO> getAllMusicalGroups() {



        return List.of();
    }
}
