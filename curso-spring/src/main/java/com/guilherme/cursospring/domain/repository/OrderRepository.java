package com.guilherme.cursospring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.cursospring.domain.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
  
}