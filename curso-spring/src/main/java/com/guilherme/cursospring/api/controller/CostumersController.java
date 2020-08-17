package com.guilherme.cursospring.api.controller;

import java.util.Arrays;
import java.util.List;

import com.guilherme.cursospring.domain.model.Costumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostumersController {
  @GetMapping("/clientes")
  public List<Costumer> listar(){
    var costumer1 = new Costumer();
    costumer1.setId(1L);
    costumer1.setEmail("guaturadzn@gmail.com");
    costumer1.setName("Guilherme Guara");
    costumer1.setPhone("19 99999-99");
    var costumer2 = new Costumer();
    costumer2.setId(2L);
    costumer2.setEmail("iruri@gmail.com");
    costumer2.setName("Iruri Correios");
    costumer2.setPhone("29 99999-99");
    return Arrays.asList(costumer1, costumer2);
  }
}