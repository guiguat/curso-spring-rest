package com.guilherme.cursospring.api.model;

import javax.validation.constraints.NotNull;

public class CostumerIdInput {

  @NotNull
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
