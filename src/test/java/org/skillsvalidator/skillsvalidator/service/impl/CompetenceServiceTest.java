package org.skillsvalidator.skillsvalidator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skillsvalidator.skillsvalidator.dto.CompetenceDTO;
import org.skillsvalidator.skillsvalidator.mapper.CompetenceMapper;
import org.skillsvalidator.skillsvalidator.model.Competence;
import org.skillsvalidator.skillsvalidator.repository.CompetenceRepository;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetenceServiceTest {
    @Mock
    private CompetenceRepository competenceRepository;
    @Mock
    private SousCompetenceRepository sousCompetenceRepository;
    @Mock
    private CompetenceMapper competenceMapper;
    @InjectMocks
    private CompetenceService competenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCompetence_Success() {
        CompetenceDTO dto = new CompetenceDTO();
        dto.setName("Compétence 1");
        dto.setSousCompetences(new ArrayList<>());
        Competence competence = new Competence();
        competence.setName("Compétence 1");
        competence.setSousCompetences(new ArrayList<>());
        when(competenceMapper.toEntity(dto)).thenReturn(competence);
        when(competenceRepository.save(any(Competence.class))).thenReturn(competence);
        when(competenceMapper.toDto(competence)).thenReturn(dto);
        CompetenceDTO result = competenceService.createCompetence(dto);
        assertNotNull(result);
        assertEquals("Compétence 1", result.getName());
        verify(competenceRepository, times(1)).save(any(Competence.class));
    }

    @Test
    void getCompetence_ReturnsDTO_WhenExists() {
        Competence competence = new Competence();
        competence.setId(1L);
        CompetenceDTO dto = new CompetenceDTO();
        dto.setId(1L);
        when(competenceRepository.findById(1L)).thenReturn(Optional.of(competence));
        when(competenceMapper.toDto(competence)).thenReturn(dto);
        CompetenceDTO result = competenceService.getCompetence(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void getCompetence_ReturnsNull_WhenNotExists() {
        when(competenceRepository.findById(2L)).thenReturn(Optional.empty());
        CompetenceDTO result = competenceService.getCompetence(2L);
        assertNull(result);
    }
}