package com.portfolio.api.Service;

import com.portfolio.api.Model.Experience;
import com.portfolio.api.Repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    public List<Experience>findExperience(){
        return experienceRepository.findAll();
    }
    
    public Experience updateExperience(Experience experience){
        return experienceRepository.save(experience);
    }
    
    public void deleteExperience(Long id){
       experienceRepository.deleteById(id);
    }
    
}
