package org.mentormatch.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "mentorship_sessions")
@Data
public class MentorshipSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mentorId; // Référence à l'ID de User (Mentor)

    @Column(nullable = false)
    private String apprenantId; // Référence à l'ID de User (Apprenant)

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String status; // Ex. "PENDING", "CONFIRMED", "COMPLETED", "CANCELLED"

    @Column
    private String notes; // Points discutés pendant la session
}