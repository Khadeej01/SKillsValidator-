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
public class SousCompetenceService {
    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceRepository competenceRepository; // Only for validation

    // Opérations 100% dédiées aux sous-compétences
    public SousCompetence createSousCompetence(SousCompetence sousCompetence, Long competenceId) {
        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow(() -> new RuntimeException("Compétence parente non trouvée"));
        sousCompetence.setCompetence(competence);
        return sousCompetenceRepository.save(sousCompetence);
    }

    public List<SousCompetence> getSousCompetencesByCompetenceId(Long competenceId) {
        return sousCompetenceRepository.findByCompetenceId(competenceId);
    }

    public SousCompetence toggleValidation(Long id, boolean isValidee) {
        SousCompetence sousCompetence = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        sousCompetence.setValidee(isValidee);
        return sousCompetenceRepository.save(sousCompetence);
    }

    // Autres méthodes indépendantes...
    public SousCompetence updateSousCompetence(Long id, SousCompetence updated) {
        SousCompetence existing = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return sousCompetenceRepository.save(existing);
    }

    public void deleteSousCompetence(Long id) {
        sousCompetenceRepository.deleteById(id);
    }
}