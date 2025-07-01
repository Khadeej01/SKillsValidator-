package org.skillsvalidator.skillsvalidator.repository;


import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {
    List<SousCompetence> findByCompetenceId(Long competenceId);
}