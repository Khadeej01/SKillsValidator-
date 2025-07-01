package org.skillsvalidator.skillsvalidator.dto;




import java.util.List;

public class CompetenceDTO {
    private Long id;
    private String nom;
    private String description;
    private List<SousCompetenceDTO> sousCompetences;
    private boolean acquis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SousCompetenceDTO> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetenceDTO> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }

    public boolean isAcquis() {
        return acquis;
    }

    public void setAcquis(boolean acquis) {
        this.acquis = acquis;
    }
}