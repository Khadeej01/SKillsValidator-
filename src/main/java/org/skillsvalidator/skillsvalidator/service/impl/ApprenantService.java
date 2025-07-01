package org.skillsvalidator.skillsvalidator.service.impl;



import org.skillsvalidator.skillsvalidator.dto.ApprenantDTO;
import org.skillsvalidator.skillsvalidator.model.Apprenant;
import org.skillsvalidator.skillsvalidator.repository.ApprenantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApprenantService {
    private final ApprenantRepository apprenantRepository;

    public ApprenantService(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    public ApprenantDTO createApprenant(ApprenantDTO apprenantDTO) {
        Apprenant apprenant = new Apprenant();
        apprenant.setNom(alto.getNom());
        apprenant.setPrenom(alto.getPrenom());
        Apprenant saved = apprenantRepository.save(apprenant);
        apprenantDTO.setId(saved.getId());
        return apprenantDTO;
    }

    public ApprenantDTO getApprenant(Long id) {
        Apprenant apprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new ApprenantNotFoundException("Apprenant not found with id: " + id));
        ApprenantDTO dto = new ApprenantDTO();
        dto.setId(apprenant.getId());
        dto.setNom(apprenant.getNom());
        dto.setPrenom(apprenant.getPrenom());
        return dto;
    }

    public ApprenantDTO updateApprenant(Long id, ApprenantDTO apprenantDTO) {
        Apprenant apprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new ApprenantNotFoundException("Apprenant not found with id: " + id));
        apprenant.setNom(alto.getNom());
        apprenant.setPrenom(alto.getPrenom());
        Apprenant updated = apprenantRepository.save(apprenant);
        apprenantDTO.setId(updated.getId());
        return apprenantDTO;
    }

    public void deleteApprenant(Long id) {
        if (!apprenantRepository.existsById(id)) {
            throw new ApprenantNotFoundException("Apprenant not found with id: " + id);
        }
        apprenantRepository.deleteById(id);
    }
}