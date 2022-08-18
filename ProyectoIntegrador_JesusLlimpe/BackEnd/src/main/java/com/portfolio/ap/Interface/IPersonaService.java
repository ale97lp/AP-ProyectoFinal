package com.portfolio.ap.Interface;

import com.portfolio.ap.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de persona
    public List<Persona> getPersona();

    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);

    //Eliminar un objeto
    public void deletePersona(Long id);

    //Buscar una persona por ID
    public Persona findPersona(Long id);

}
