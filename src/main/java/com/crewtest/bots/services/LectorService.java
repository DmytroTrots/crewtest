package com.crewtest.bots.services;

import com.crewtest.bots.entities.LectorEntity;
import com.crewtest.bots.repositories.LectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    private final LectorRepository lectorRepository;

    public LectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    public List<LectorEntity> getAllLectorsWhereNameOrSurnameLikeString(String searchField) {
        return lectorRepository.findLectorEntitiesWhereNameOrSurnameLike(searchField);
    }
}
