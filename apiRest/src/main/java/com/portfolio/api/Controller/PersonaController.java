package com.portfolio.api.Controller;

import com.portfolio.api.Model.Persona;
import com.portfolio.api.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    PersonaService pS;

    @PostMapping("/persona")
    public void createPersona(@RequestBody Persona persona) {
        pS.createPersona(persona);
    }
    
    @PutMapping("/persona/update")
    public void updatePersona(@RequestBody Persona persona) {
        pS.updatePersona(persona);
    }

    @DeleteMapping("/persona/{id}")
    public void deletePersona(@PathVariable Long id) {
        pS.deletePersona(id);
    }

    @GetMapping("/persona/{id}")
    @ResponseBody
    public Persona findPersona(@PathVariable long id) {
        return pS.findPersona(id);
    }

    @GetMapping("/persona")
    @ResponseBody
    public List<Persona> findPersonas() {
        return pS.findPersonas();
    }

}
