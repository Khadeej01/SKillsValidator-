package org.mentormatch.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "mentor")
@Data
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId; // Référence à l'ID de User

    @ElementCollection
    @CollectionTable(name = "mentor_skills", joinColumns = @JoinColumn(name = "mentor_id"))
    @Column(name = "skill")
    private List<String> skills; // Ex. ["Programmation", "Marketing"]

    @Column
    private String experience; // Description de l'expérience

    @Column(nullable = false)
    private boolean validated = false; // Validé par l'admin

    @ElementCollection
    @CollectionTable(name = "mentor_availabilities", joinColumns = @JoinColumn(name = "mentor_id"))
    private List<Availability> availabilities; // Créneaux horaires
}