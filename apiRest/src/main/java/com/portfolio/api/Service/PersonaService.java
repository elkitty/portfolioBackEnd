package com.portfolio.api.Service;

import com.portfolio.api.Model.Persona;
import com.portfolio.api.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class PersonaService {

    private final PersonaRepository personaRepo;

    @Autowired
    public PersonaService(PersonaRepository personaRepo) {
        this.personaRepo = personaRepo;
    }
    
    public Persona createPersona(Persona persona) {
        return personaRepo.save(persona);
    }

    public List<Persona> findPersonas() {
        return personaRepo.findAll();
    }

    public Persona findPersona(Integer id) {
        return personaRepo.findById(id).orElse(null);
    }

    public Persona updatePersona(Persona persona) {
        return personaRepo.save(persona);
    }

    public void deletePersona(Integer id) {
        personaRepo.deleteById(id);
    }

}
