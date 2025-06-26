package org.mentormatch.backend.service;

import org.mentormatch.backend.model.Mentor;
import org.mentormatch.backend.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Optional<Mentor> getMentorById(Long id) {
        return mentorRepository.findById(id);
    }

    public Mentor createMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Long id, Mentor mentorDetails) {
        return mentorRepository.findById(id).map(mentor -> {
            mentor.setSkills(mentorDetails.getSkills());
            mentor.setExperience(mentorDetails.getExperience());
            mentor.setValidated(mentorDetails.isValidated());
            mentor.setAvailabilities(mentorDetails.getAvailabilities());
            return mentorRepository.save(mentor);
        }).orElse(null);
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
} 