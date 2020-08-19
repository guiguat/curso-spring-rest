package com.guilherme.cursospring.domain.service;

import com.guilherme.cursospring.domain.exception.DomainException;
import com.guilherme.cursospring.domain.model.Costumer;
import com.guilherme.cursospring.domain.repository.CostumerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCostumerService {
  
  @Autowired
  private CostumerRepository costumerRepository;

  public Costumer save(Costumer costumer){
    Costumer prevCostumer = costumerRepository.findByEmail(costumer.getEmail());
    if(prevCostumer != null && !prevCostumer.equals(costumer)){
      throw new DomainException("There is already a costumer with this email.");
    }
    return costumerRepository.save(costumer);
  }

  public void delete(Long costumerId){
    costumerRepository.deleteById(costumerId);
  }

}