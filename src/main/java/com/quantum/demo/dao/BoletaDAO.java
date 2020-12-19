package com.quantum.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quantum.demo.model.Boleta;

public interface BoletaDAO extends JpaRepository<Boleta, String> {

}