package org.skillsvalidator.skillsvalidator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.skillsvalidator.skillsvalidator.dto.CompetenceDTO;
import org.skillsvalidator.skillsvalidator.model.Competence;
import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetenceDTO toDto(Competence competence);
    Competence toEntity(CompetenceDTO competenceDTO);

    List<CompetenceDTO> toDtoList(List<Competence> competences);
    List<Competence> toEntityList(List<CompetenceDTO> competenceDTOs);


    SousCompetenceDTO toSousCompetenceDto(SousCompetence sousCompetence);
    SousCompetence toSousCompetenceEntity(SousCompetenceDTO sousCompetenceDTO);

    List<SousCompetenceDTO> toSousCompetenceDtoList(List<SousCompetence> sousCompetences);
    List<SousCompetence> toSousCompetenceEntityList(List<SousCompetenceDTO> sousCompetenceDTOs);
}