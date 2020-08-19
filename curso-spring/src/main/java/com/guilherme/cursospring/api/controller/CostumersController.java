package com.guilherme.cursospring.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.guilherme.cursospring.domain.model.Costumer;
import com.guilherme.cursospring.domain.repository.CostumerRepository;
import com.guilherme.cursospring.domain.service.RegisterCostumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costumers")
public class CostumersController {

  @Autowired
  private CostumerRepository costumerRepository;

  @Autowired
  private RegisterCostumerService registerCostumerService;

  @GetMapping
  public List<Costumer> listar(){
    return costumerRepository.findAll();
  }

  @GetMapping("/{costumerId}")
  public ResponseEntity<Costumer> find(@PathVariable Long costumerId){
    Optional<Costumer> costumer = costumerRepository.findById(costumerId);
    if(costumer.isPresent()){
      return ResponseEntity.ok(costumer.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Costumer create(@Valid @RequestBody Costumer costumer){
    return registerCostumerService.save(costumer);
  }

  @PutMapping("/{costumerId}")
  public ResponseEntity<Costumer> update(@PathVariable Long costumerId, @Valid @RequestBody Costumer costumer){
    if(!costumerRepository.existsById(costumerId)){
      return ResponseEntity.notFound().build();
    }
    costumer.setId(costumerId);
    costumer = registerCostumerService.save(costumer);
    return ResponseEntity.ok(costumer);
  }

  @DeleteMapping("/{costumerId}")
  public ResponseEntity<Void> delete(@PathVariable Long costumerId){
    if(!costumerRepository.existsById(costumerId)){
      return ResponseEntity.notFound().build();
    }
    registerCostumerService.delete(costumerId);
    return ResponseEntity.noContent().build();
  }
}