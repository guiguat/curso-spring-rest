package com.guilherme.cursospring.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.guilherme.cursospring.api.model.CommentInput;
import com.guilherme.cursospring.api.model.CommentModel;
import com.guilherme.cursospring.domain.exception.EntityNotFoundException;
import com.guilherme.cursospring.domain.model.Comment;
import com.guilherme.cursospring.domain.model.Order;
import com.guilherme.cursospring.domain.repository.OrderRepository;
import com.guilherme.cursospring.domain.service.ManageOrderService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/{orderId}/comments")
public class CommentController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ManageOrderService manageOrderService;

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentModel add(
   @PathVariable Long orderId,
   @Valid @RequestBody CommentInput commentInput){
    Comment comment = manageOrderService
      .addComment(orderId, commentInput.getDescription());
    return toModel(comment);
  }

  @GetMapping
  public List<CommentModel> list(@PathVariable Long orderId){
    Order order = orderRepository.findById(orderId)
      .orElseThrow(()-> new EntityNotFoundException("Order not found."));
    return toCollectionModel(order.getComments());
  }

  private CommentModel toModel(Comment comment){
    return modelMapper.map(comment, CommentModel.class);
  }

  private List<CommentModel> toCollectionModel(List<Comment> comments){
    return comments.stream()
            .map(comment -> toModel(comment))
            .collect(Collectors.toList());
  }
}