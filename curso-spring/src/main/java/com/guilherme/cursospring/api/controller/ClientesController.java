package com.guilherme.cursospring.api.controller;

import java.util.Arrays;
import java.util.List;

import com.guilherme.cursospring.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientesController {
  @GetMapping("/clientes")
  public List<Cliente> listar(){
    var cliente1 = new Cliente();
    cliente1.setId(1L);
    cliente1.setEmail("guaturadzn@gmail.com");
    cliente1.setNome("Guilherme Guara");
    cliente1.setTelefone("19 99999-99");
    var cliente2 = new Cliente();
    cliente2.setId(2L);
    cliente2.setEmail("iruri@gmail.com");
    cliente2.setNome("Iruri Correios");
    cliente2.setTelefone("29 99999-99");
    return Arrays.asList(cliente1, cliente2);
  }
}