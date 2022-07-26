package com.portfolio.api.Controller;

import com.portfolio.api.Model.Skills;
import com.portfolio.api.Service.SkillsService;
import java.util.List;
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
@RequestMapping("/skills")

public class SkillsController {

    private final SkillsService sS;

    public SkillsController(SkillsService sS) {
        this.sS = sS;
    }

    @PostMapping("/add")
    public ResponseEntity<Skills> createSkills(@RequestBody Skills skills) {
        Skills newSkills = sS.addSkills(skills);
        return new ResponseEntity<>(newSkills, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> findSkills() {
        List<Skills> skillss = sS.findSkills();
        return new ResponseEntity<>(skillss, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skills> updateSkills(@RequestBody Skills skills) {
        Skills updateSkills = sS.updateSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable("id") Long id) {
        sS.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


