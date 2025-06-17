package org.mentormatch.backend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "apprenant")
@Data
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column
    private String objectives;

    @Column
    private String educationLevel; // Ex. "Licence", "Master"
}