package com.portfolio.api.Service;

import com.portfolio.api.Model.Skills;
import com.portfolio.api.Repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    private final SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }
    
    public Skills addSkills(Skills skills) {
        return skillsRepository.save(skills);
    }
    
    public List<Skills>findSkills(){
        return skillsRepository.findAll();
    }
    
    public Skills updateSkills(Skills skills){
        return skillsRepository.save(skills);
    }
    
    public void deleteSkills(Long id){
       skillsRepository.deleteById(id);
    }
    
}
