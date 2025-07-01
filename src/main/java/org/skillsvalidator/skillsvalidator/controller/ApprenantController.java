package org.skillsvalidator.skillsvalidator.controller;



import org.skillsvalidator.skillsvalidator.dto.ApprenantDTO;
import org.skillsvalidator.skillsvalidator.service.impl.ApprenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apprenants")
public class ApprenantController {
    private final ApprenantService apprenantService;

    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @PostMapping
    public ResponseEntity<ApprenantDTO> createApprenant(@RequestBody ApprenantDTO apprenantDTO) {
        return new ResponseEntity<>(apprenantService.createApprenant(apprenantDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprenantDTO> getApprenant(@PathVariable Long id) {
        return ResponseEntity.ok(apprenantService.getApprenant(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApprenantDTO> updateApprenant(@PathVariable Long id, @RequestBody ApprenantDTO apprenantDTO) {
        return ResponseEntity.ok(apprenantService.updateApprenant(id, apprenantDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppr SanchoResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }
}