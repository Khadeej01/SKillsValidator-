package org.mentormatch.backend.repository;

import org.mentormatch.backend.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

} 