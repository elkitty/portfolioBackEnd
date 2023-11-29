package com.portfolio.api.Controller;

import com.portfolio.api.Model.Persona;
import com.portfolio.api.Service.PersonaService;
import java.util.List;
import javax.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/persona")

public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/all")
    @ResponseBody
    public List<Persona> findPersonas() {
        return personaService.findPersonas();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Persona findPersona(@PathVariable Integer id) {
        return personaService.findPersona(id);
    }

//    @PutMapping("/update")
//    public void updatePersona(@RequestBody Persona persona) {
//        personaService.updatePersona(persona);
//    }

    @PostMapping("/add")
    public void createPersona(@RequestBody Persona persona) {
        personaService.createPersona(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id) {
        personaService.deletePersona(id);
    }

    @PutMapping("/update")
    public void updatePersona(@RequestBody Persona persona) {
        // Buscar la persona existente con ID 1
        Persona existingPersona = personaService.findPersona(1);

        if (existingPersona != null) {
            // Actualizar los campos de la persona existente con los nuevos valores
            existingPersona.setFullName(persona.getFullName());
            existingPersona.setPosition(persona.getPosition());
            existingPersona.setLocation(persona.getLocation());
            existingPersona.setUrlImage(persona.getUrlImage());
            existingPersona.setAbout(persona.getAbout());
            
            // Guardar la persona actualizada en la base de datos
            personaService.updatePersona(existingPersona);
        }
    }

}
