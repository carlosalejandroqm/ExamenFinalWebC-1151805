package com.quantum.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quantum.demo.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, String> {

}