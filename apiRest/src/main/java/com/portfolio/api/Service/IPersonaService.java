
package com.portfolio.api.Service;

import com.portfolio.api.Model.Persona;
import java.util.List;


public interface IPersonaService {
    public void createPersona(Persona persona);
    public void deletePersona(Long id);
    public List<Persona>findPersonas();
    
}
