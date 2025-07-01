package org.skillsvalidator.skillsvalidator.controller;


import lombok.RequiredArgsConstructor;
import org.skillsvalidator.skillsvalidator.model.Competence;

import org.skillsvalidator.skillsvalidator.service.impl.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
@RequiredArgsConstructor
public class CompetenceController {
    private final CompetenceService competenceService;

    @GetMapping
    public List<Competence> getAll() {
        return competenceService.getAllCompetences();
    }

    @PostMapping
    public Competence create(@RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    // Pas de mélange avec les sous-compétences ici !
}