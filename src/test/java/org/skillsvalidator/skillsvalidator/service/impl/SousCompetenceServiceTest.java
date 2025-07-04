package org.skillsvalidator.skillsvalidator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.mapper.CompetenceMapper;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.skillsvalidator.skillsvalidator.repository.SousCompetenceRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SousCompetenceServiceTest {
    @Mock
    private SousCompetenceRepository sousCompetenceRepository;
    @Mock
    private CompetenceMapper competenceMapper;
    @InjectMocks
    private SousCompetenceService sousCompetenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSousCompetence_ReturnsDTO_WhenExists() {
        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setId(1L);
        SousCompetenceDTO dto = new SousCompetenceDTO();
        dto.setId(1L);
        when(sousCompetenceRepository.findById(1L)).thenReturn(Optional.of(sousCompetence));
        when(competenceMapper.toSousCompetenceDto(sousCompetence)).thenReturn(dto);

        SousCompetenceDTO result = sousCompetenceService.getSousCompetence(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(sousCompetenceRepository, times(1)).findById(1L);
        verify(competenceMapper, times(1)).toSousCompetenceDto(sousCompetence);
    }

    @Test
    void getSousCompetence_ReturnsNull_WhenNotExists() {
        when(sousCompetenceRepository.findById(2L)).thenReturn(Optional.empty());

        SousCompetenceDTO result = sousCompetenceService.getSousCompetence(2L);

        assertNull(result);
        verify(sousCompetenceRepository, times(1)).findById(2L);
        verify(competenceMapper, never()).toSousCompetenceDto(any());
    }
}