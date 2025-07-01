package org.skillsvalidator.skillsvalidator.controller;


import lombok.RequiredArgsConstructor;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.service.impl.SousCompetenceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sous-competences")
@RequiredArgsConstructor
public class SousCompetenceController {
    private final SousCompetenceService sousCompetenceService;

    @PostMapping("/competence/{competenceId}")
    public SousCompetence create(
            @RequestBody SousCompetence sousCompetence,
            @PathVariable Long competenceId) {
        return sousCompetenceService.createSousCompetence(sousCompetence, competenceId);
    }

    @PatchMapping("/{id}/validation")
    public SousCompetence toggleValidation(
            @PathVariable Long id,
            @RequestParam boolean isValidee) {
        return sousCompetenceService.toggleValidation(id, isValidee);
    }

    // Endpoints purement dédiés...
}