package com.guilherme.cursospring.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.guilherme.cursospring.domain.exception.DomainException;

@Entity(name = "order_service")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Costumer costumer;

  private String description;
  private BigDecimal price;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
  
  private OffsetDateTime openDate;
  private OffsetDateTime finishDate;

  @OneToMany(mappedBy = "order")
  private List<Comment> comments = new ArrayList<Comment>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Costumer getCostumer() {
    return costumer;
  }

  public void setCostumer(Costumer costumer) {
    this.costumer = costumer;
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
  
  public List<Comment> getComments() {
    return comments;
  }
  
  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  public boolean canBeFinished(){
    return OrderStatus.OPEN.equals(getStatus());
  }

  public void finish() {
    if(!canBeFinished()){
      throw new DomainException("This order can't be finished");
    }
    setStatus(OrderStatus.FINISHED);
    setFinishDate(OffsetDateTime.now());
  }
  
}