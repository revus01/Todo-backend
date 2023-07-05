package com.todo.dao.Todo;

import java.time.LocalDateTime;
import java.util.List;

import com.todo.entity.TodoEntity;

public interface TodoDao {

    List<TodoEntity> inquireTodoEntity(Long uid);
    
    TodoEntity createTodoEntity(Long createdUser, String title, LocalDateTime startTime, LocalDateTime endTime, Boolean isComplete);

    TodoEntity modifyTodoEntity(Long id, Boolean isComplete);

    TodoEntity removeTodoEntity(Long id);

}
