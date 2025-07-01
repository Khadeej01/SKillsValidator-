package org.skillsvalidator.skillsvalidator.model;



import jakarta.persistence.*;
import org.apache.el.util.Validation;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apprenants")
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private List<Validation> validations = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public List<Validation> getValidations() { return validations; }
    public void setValidations(List<Validation> validations) { this.validations = validations; }
}