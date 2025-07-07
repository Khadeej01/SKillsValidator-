package org.skillsvalidator.skillsvalidator.service.impl;

import org.skillsvalidator.skillsvalidator.dto.CompetenceDTO;
import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.mapper.CompetenceMapper;
import org.skillsvalidator.skillsvalidator.model.Competence;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.repository.CompetenceRepository;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    @Autowired
    private CompetenceMapper competenceMapper;

    public CompetenceDTO createCompetence(CompetenceDTO competenceDTO) {
        Competence competence = competenceMapper.toEntity(competenceDTO);
        if (competence.getSousCompetences() == null) {
            competence.setSousCompetences(new java.util.ArrayList<>());
        }
        competence.getSousCompetences().forEach(sousCompetence -> sousCompetence.setCompetence(competence));
        Competence savedCompetence = competenceRepository.save(competence);
        return competenceMapper.toDto(savedCompetence);
    }

    public List<CompetenceDTO> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        return competences.stream()
                .map(competenceMapper::toDto)
                .collect(Collectors.toList());
    }

    public CompetenceDTO getCompetence(Long id) {
        Optional<Competence> competence = competenceRepository.findById(id);
        return competence.map(competenceMapper::toDto).orElse(null);
    }

    public SousCompetenceDTO updateSousCompetence(Long competenceId, Long sousId, SousCompetenceDTO sousCompetenceDTO) {
        Optional<SousCompetence> sousCompetence = sousCompetenceRepository.findById(sousId);
        if (sousCompetence.isPresent()) {
            SousCompetence updatedSousCompetence = sousCompetence.get();
            updatedSousCompetence.setValidated(sousCompetenceDTO.isValidated());
            sousCompetenceRepository.save(updatedSousCompetence);

            // Logique de validation de la compétence
            Optional<Competence> competenceOpt = competenceRepository.findById(competenceId);
            if (competenceOpt.isPresent()) {
                Competence competence = competenceOpt.get();
                List<SousCompetence> sousCompetences = competence.getSousCompetences();
                boolean allValidated = sousCompetences.stream().allMatch(SousCompetence::isValidated);
                competence.setValidated(allValidated);
                competenceRepository.save(competence);
            }

            return competenceMapper.toSousCompetenceDto(updatedSousCompetence);
        }
        return null;
    }

    public void deleteCompetence(Long id) {
        if (competenceRepository.existsById(id)) {
            competenceRepository.deleteById(id);
        }
    }
}