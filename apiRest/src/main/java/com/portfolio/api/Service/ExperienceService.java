package com.portfolio.api.Service;

import com.portfolio.api.Excepcion.ResourceNotFoundException;
import com.portfolio.api.Model.Experience;
import com.portfolio.api.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> findAllExperiences() {
        return experienceRepository.findAll();
    }

   
    public Experience findExperienceById(Integer id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
    
    public Experience updateExperience(Integer id, Experience experience) {
    Optional<Experience> optionalExperience = experienceRepository.findById(id);

    if (optionalExperience.isPresent()) {
        Experience existingExperience = optionalExperience.get();
        // Actualiza los campos que desees
        existingExperience.setPosition(experience.getPosition());
        existingExperience.setMode(experience.getMode());
        existingExperience.setStart(experience.getStart());
        existingExperience.setEnd(experience.getEnd());
        existingExperience.setUrlImage(experience.getUrlImage());

        // Guarda la experiencia actualizada en la base de datos
        return experienceRepository.save(existingExperience);
    } else {
        // Manejar el caso en que no se encuentra la experiencia con el ID proporcionado
        throw new ResourceNotFoundException("Experience not found with id: " + id);
    }
}


    public void deleteExperience(Integer id) {
        experienceRepository.deleteById(id);
    }
}
