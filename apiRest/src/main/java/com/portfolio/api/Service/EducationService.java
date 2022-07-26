package com.portfolio.api.Service;

import com.portfolio.api.Model.Education;
import com.portfolio.api.Repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducationService {
    private final EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
    
    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }
    
    public List<Education>findEducation(){
        return educationRepository.findAll();
    }
    
    public Education updateEducation(Education education){
        return educationRepository.save(education);
    }
    
    public void deleteEducation(Long id){
       educationRepository.deleteById(id);
    }
    
}
