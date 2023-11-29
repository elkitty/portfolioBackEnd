package com.portfolio.api.Service;

import com.portfolio.api.Model.Skill;
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
    
    public Skill addSkills(Skill skills) {
        return skillsRepository.save(skills);
    }
    
    public List<Skill>findSkills(){
        return skillsRepository.findAll();
    }
    
    public Skill updateSkills(Skill skills){
        return skillsRepository.save(skills);
    }
    
    public void deleteSkills(Integer id){
       skillsRepository.deleteById(id);
    }
    
}
