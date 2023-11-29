package com.portfolio.api.Controller;

import com.portfolio.api.Excepcion.ResourceNotFoundException;
import com.portfolio.api.Model.Experience;
import com.portfolio.api.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/experience")
public class ExperienceController {

    private static final Logger logger = LoggerFactory.getLogger(ExperienceController.class);

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/all")
    public List<Experience> findAllExperiences() {
        List<Experience> experiences = this.experienceService.findAllExperiences();
        return experiences;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Integer id) {
        Experience experience = this.experienceService.findExperienceById(id);
        if (experience != null) {
            return ResponseEntity.ok(experience);
        } else {
            throw new ResourceNotFoundException("No se encontro el ID " + id);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        logger.info("URL de Imagen recibida: {}", experience.getUrlImage());
        Experience newExperience = experienceService.addExperience(experience);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Integer id, @RequestBody Experience experience) {
        Experience updatedExperience = experienceService.updateExperience(id, experience);
        return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable Integer id) {
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
