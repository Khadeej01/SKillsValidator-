package org.skillsvalidator.skillsvalidator.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SousCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean isValidee;  // Par défaut false

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;
}