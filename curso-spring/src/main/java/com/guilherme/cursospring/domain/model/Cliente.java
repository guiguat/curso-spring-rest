package com.guilherme.cursospring.domain.model;

public class Cliente {
  private Long id;
  private String nome;
  private String email;
  private String telefone;

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(Long id) {
    this.id = id;
  }
}