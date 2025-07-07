package org.skillsvalidator.skillsvalidator.controller;

import org.skillsvalidator.skillsvalidator.dto.CompetenceDTO;
import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.service.impl.CompetenceService;
import org.skillsvalidator.skillsvalidator.service.impl.SousCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @PostMapping
    public ResponseEntity<CompetenceDTO> createCompetence(@RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO savedCompetence = competenceService.createCompetence(competenceDTO);
        return ResponseEntity.ok(savedCompetence);
    }

    @GetMapping
    public List<CompetenceDTO> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenceDTO> getCompetence(@PathVariable Long id) {
        CompetenceDTO competence = competenceService.getCompetence(id);
        return competence != null ? ResponseEntity.ok(competence) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/sousCompetences/{sousId}")
    public ResponseEntity<SousCompetenceDTO> updateSousCompetence(@PathVariable Long id, @PathVariable Long sousId, @RequestBody SousCompetenceDTO sousCompetenceDTO) {
        SousCompetenceDTO updatedSousCompetence = competenceService.updateSousCompetence(id, sousId, sousCompetenceDTO);
        return updatedSousCompetence != null ? ResponseEntity.ok(updatedSousCompetence) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.ok().build();
    }
}