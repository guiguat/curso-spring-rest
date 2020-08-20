package com.guilherme.cursospring.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderInput {

  @NotBlank
  private String description;

  @NotNull
  private BigDecimal price;

  @Valid
  @NotNull
  private CostumerIdInput costumer;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public CostumerIdInput getCostumer() {
    return costumer;
  }

  public void setCostumer(CostumerIdInput costumer) {
    this.costumer = costumer;
  }
}