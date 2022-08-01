package com.portfolio.api.Controller;

import com.portfolio.api.Model.Experience;
import com.portfolio.api.Model.Persona;
import com.portfolio.api.Service.ExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")

public class ExperienceController {
    
    @Autowired
    ExperienceService exS;

    public ExperienceController(ExperienceService exS) {
        this.exS = exS;
    }

    @PostMapping("/add")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        Experience newExperience = exS.addExperience(experience);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> findExperience() {
        List<Experience> educations = exS.findExperience();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience) {
//        Experience updateExperience = exS.updateExperience(experience);
//        return new ResponseEntity<>(updateExperience, HttpStatus.OK);
//    }
    
     @PostMapping("/edit")
    public void updateExperience(@RequestBody Experience experience) {
        exS.updateExperience(experience);
    }
    
  

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long id) {
        exS.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
