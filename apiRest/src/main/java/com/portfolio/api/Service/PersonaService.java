package com.portfolio.api.Service;

import com.portfolio.api.Model.Persona;
import com.portfolio.api.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepo;

    @Override
    public void createPersona(Persona persona) {
        personaRepo.save(persona);
    }

    public void updatePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public List<Persona> findPersonas() {
        return personaRepo.findAll();
    }

    public Persona findPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

}
