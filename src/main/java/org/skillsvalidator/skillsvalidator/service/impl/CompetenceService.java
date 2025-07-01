package org.skillsvalidator.skillsvalidator.service.impl;


import lombok.RequiredArgsConstructor;
import org.skillsvalidator.skillsvalidator.model.Competence;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.repository.CompetenceRepository;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    // Opérations purement liées aux compétences
    public Competence createCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Competence getCompetenceById(Long id) {
        return competenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }

    public Competence updateCompetence(Long id, Competence updatedCompetence) {
        Competence existing = getCompetenceById(id);
        existing.setName(updatedCompetence.getName());
        existing.setDescription(updatedCompetence.getDescription());
        return competenceRepository.save(existing);
    }
}