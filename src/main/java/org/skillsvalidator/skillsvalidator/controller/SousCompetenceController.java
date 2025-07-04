package org.skillsvalidator.skillsvalidator.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sous-competences")

public class SousCompetenceController {

    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    @GetMapping
    @Operation(summary = "Liste toutes les sous-compétences", description = "Retourne la liste de toutes les sous-compétences")
    public List<SousCompetence> getAllSousCompetences() {
        return sousCompetenceRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une sous-compétence par ID", description = "Retourne les détails d'une sous-compétence spécifique")
    public SousCompetence getSousCompetence(@Parameter(description = "ID de la sous-compétence à récupérer") @PathVariable Long id) {
        return sousCompetenceRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle sous-compétence", description = "Ajoute une nouvelle sous-compétence à la base de données")
    public SousCompetence createSousCompetence(@RequestBody SousCompetence sousCompetence) {
        return sousCompetenceRepository.save(sousCompetence);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une sous-compétence", description = "Supprime une sous-compétence par son ID")
    public void deleteSousCompetence(@Parameter(description = "ID de la sous-compétence à supprimer") @PathVariable Long id) {
        sousCompetenceRepository.deleteById(id);
    }
}