package com.portfolio.api.Controller;

import com.portfolio.api.Model.Skill;
import com.portfolio.api.Service.SkillsService;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/skills")

public class SkillsController {

    private final SkillsService sS;

    public SkillsController(SkillsService sS) {
        this.sS = sS;
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> createSkills(@RequestBody Skill skills) {
        Skill newSkills = sS.addSkills(skills);
        return new ResponseEntity<>(newSkills, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> findSkills() {
        List<Skill> skillss = sS.findSkills();
        return new ResponseEntity<>(skillss, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> updateSkills(@RequestBody Skill skills) {
        Skill updateSkills = sS.updateSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable("id") Integer id) {
        sS.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


