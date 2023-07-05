package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.TodoEntity;
import java.util.List;


public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByCreatedUser(Long createdUser);
}
