package com.guilherme.cursospring.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.guilherme.cursospring.api.model.OrderInput;
import com.guilherme.cursospring.api.model.OrderModel;
import com.guilherme.cursospring.domain.model.Order;
import com.guilherme.cursospring.domain.repository.OrderRepository;
import com.guilherme.cursospring.domain.service.ManageOrderService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private ManageOrderService manageOrderService;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderModel create(@Valid @RequestBody OrderInput order){
    return toModel(manageOrderService.create(toEntity(order)));
  }

  @GetMapping
  public List<OrderModel> index(){
    return toCollectionModel(orderRepository.findAll());
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderModel> find(@PathVariable Long orderId){
    Optional<Order> order = orderRepository.findById(orderId);
    if(order.isPresent()){
      return ResponseEntity.ok(toModel(order.get()));
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{orderId}/finish")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void finish(@PathVariable Long orderId){
    manageOrderService.finish(orderId);
  }

  private OrderModel toModel(Order order){
    return modelMapper.map(order, OrderModel.class);
  }

  private List<OrderModel> toCollectionModel(List<Order> orderList){
    return orderList.stream()
            .map(order -> toModel(order))
            .collect(Collectors.toList());
  }

  private Order toEntity(OrderInput orderInput){
    return modelMapper.map(orderInput, Order.class);
  }
}