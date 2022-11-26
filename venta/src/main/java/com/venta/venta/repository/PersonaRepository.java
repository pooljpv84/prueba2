package com.venta.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venta.venta.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
