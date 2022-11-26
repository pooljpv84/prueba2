package com.venta.venta.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.venta.dto.PersonaDireccionDTO;
import com.venta.venta.model.Persona;
import com.venta.venta.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaDireccionDTO> getPersonaDireccion(){
        return personaRepository.findAll().stream().map(this::convertirEntidadToDTO).collect(Collectors.toList());
    }

     private PersonaDireccionDTO convertirEntidadToDTO(Persona persona){
         PersonaDireccionDTO personaDireccionDTO = new PersonaDireccionDTO();
         personaDireccionDTO.setPersonaId(persona.getId());
         personaDireccionDTO.setDescripcion(persona.getDescripcion());
         return personaDireccionDTO;
     }

    public Persona create(Persona persona){
        return personaRepository.save(persona);
    }

    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }

    public void eliminarPersona(Persona persona){
        personaRepository.delete(persona);
    }


    public Persona buscarId(Long id){
        return personaRepository.findById(id).get();
    }
}
