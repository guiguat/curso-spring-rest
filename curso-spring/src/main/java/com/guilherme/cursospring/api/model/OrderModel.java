package com.guilherme.cursospring.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.guilherme.cursospring.domain.model.OrderStatus;

public class OrderModel {
  private Long id;
  private CostumerResumeModel costumer;
  private String description;
  private BigDecimal price;
  private OrderStatus status;
  private OffsetDateTime openDate;
  private OffsetDateTime finishDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public OffsetDateTime getOpenDate() {
    return openDate;
  }

  public void setOpenDate(OffsetDateTime openDate) {
    this.openDate = openDate;
  }

  public OffsetDateTime getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(OffsetDateTime finishDate) {
    this.finishDate = finishDate;
  }

  public CostumerResumeModel getCostumer() {
    return costumer;
  }

  public void setCostumer(CostumerResumeModel costumer) {
    this.costumer = costumer;
  }
}