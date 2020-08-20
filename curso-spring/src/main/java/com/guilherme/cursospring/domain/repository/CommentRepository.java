package com.guilherme.cursospring.domain.repository;

import com.guilherme.cursospring.domain.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
  
}