package org.mentormatch.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Embeddable
@Data
class Availability {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean booked = false;
}


