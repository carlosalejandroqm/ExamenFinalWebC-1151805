package com.quantum.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quantum.demo.model.Numero;

public interface NumeroDAO extends JpaRepository<Numero, String> {

}