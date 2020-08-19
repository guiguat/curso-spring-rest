package com.guilherme.cursospring.domain.repository;

import java.util.List;

import com.guilherme.cursospring.domain.model.Costumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
  List<Costumer> findByNameContaining(String name);
  Costumer findByEmail(String email);
}