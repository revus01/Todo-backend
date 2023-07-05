package com.todo.service.Todo;

import java.time.LocalDateTime;
import java.util.List;

import com.todo.dto.TodoDTO;

public interface TodoService {

    List<TodoDTO> inquireTodo(Long uid);
    
    TodoDTO createTodo(Long id, Long createdUser, String title, LocalDateTime startTime, LocalDateTime endTime, Boolean isComplete);

    TodoDTO modifyTodo(Long id, Boolean isComplete);

    TodoDTO removeTodo(Long id);

}
