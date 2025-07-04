package org.skillsvalidator.skillsvalidator.service.impl;

import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.mapper.CompetenceMapper;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SousCompetenceService {
    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    @Autowired
    private CompetenceMapper competenceMapper;

    public SousCompetenceDTO getSousCompetence(Long id) {
        Optional<SousCompetence> sousCompetence = sousCompetenceRepository.findById(id);
        return sousCompetence.map(competenceMapper::toSousCompetenceDto).orElse(null);
    }
}