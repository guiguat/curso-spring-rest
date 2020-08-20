package com.guilherme.cursospring.domain.service;

import java.time.OffsetDateTime;

import com.guilherme.cursospring.domain.exception.DomainException;
import com.guilherme.cursospring.domain.exception.EntityNotFoundException;
import com.guilherme.cursospring.domain.model.Comment;
import com.guilherme.cursospring.domain.model.Costumer;
import com.guilherme.cursospring.domain.model.Order;
import com.guilherme.cursospring.domain.model.OrderStatus;
import com.guilherme.cursospring.domain.repository.CommentRepository;
import com.guilherme.cursospring.domain.repository.CostumerRepository;
import com.guilherme.cursospring.domain.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageOrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CostumerRepository costumerRepository;

  @Autowired
  private CommentRepository commentRepository;

  public Order create(Order order){
    Costumer costumer = costumerRepository.findById(order.getCostumer().getId())
      .orElseThrow(()-> new DomainException("Costumer not found."));
    order.setCostumer(costumer);
    order.setStatus(OrderStatus.OPEN);
    order.setOpenDate(OffsetDateTime.now());
    return orderRepository.save(order);
  }

  public Comment addComment(Long orderId, String description){
    Order order = search(orderId);
    Comment comment = new Comment();
    comment.setSentDate(OffsetDateTime.now());
    comment.setDescription(description);
    comment.setOrder(order);

    return commentRepository.save(comment);
  }

  public void finish(Long orderId){
    Order order = search(orderId);
    order.finish();
    orderRepository.save(order);
  }

  private Order search(Long orderId) {
    Order order = orderRepository.findById(orderId)
      .orElseThrow(()-> new EntityNotFoundException("Order not found."));
    return order;
  }
}