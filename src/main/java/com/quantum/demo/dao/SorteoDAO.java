package com.quantum.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quantum.demo.model.Sorteo;

public interface SorteoDAO extends JpaRepository<Sorteo, String> {

}