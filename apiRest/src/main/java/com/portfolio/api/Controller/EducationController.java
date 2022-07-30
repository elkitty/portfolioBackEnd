package com.portfolio.api.Controller;

import com.portfolio.api.Model.Education;
import com.portfolio.api.Service.EducationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080" })
@RequestMapping("/education")

public class EducationController {

    private final EducationService eS;

    public EducationController(EducationService eS) {
        this.eS = eS;
    }

    @PostMapping("/add")
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education newEducation = eS.addEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Education>> findEducation() {
        List<Education> educations = eS.findEducation();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Education> updateEducation(@RequestBody Education education) {
        Education updateEducation = eS.updateEducation(education);
        return new ResponseEntity<>(updateEducation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id) {
        eS.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
