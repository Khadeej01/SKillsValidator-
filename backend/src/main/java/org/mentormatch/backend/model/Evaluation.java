package org.mentormatch.backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluations")
@Data
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mentorshipSessionId;

    @Column(nullable = false)
    private String apprenantId;

    @Column(nullable = false)
    private int rating;

    @Column
    private String comment;
}