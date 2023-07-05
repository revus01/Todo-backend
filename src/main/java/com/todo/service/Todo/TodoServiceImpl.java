package com.todo.service.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.Todo.TodoDao;
import com.todo.dto.TodoDTO;
import com.todo.entity.TodoEntity;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDao todoDao;

    @Override
    public List<TodoDTO> inquireTodo(Long uid) {
        
        List<TodoEntity> entityList = todoDao.inquireTodoEntity(uid);

        List<TodoDTO> dtoList =  entityList.stream().map(TodoEntity::toDto).collect(Collectors.toList());

        return dtoList;

        

    }
    

    @Override
    public TodoDTO createTodo(Long id, Long createdUser, String title, LocalDateTime startTime, LocalDateTime endTime, Boolean isComplete){

        TodoEntity todoEntity = todoDao.createTodoEntity(createdUser, title, startTime, endTime, isComplete);

        TodoDTO todoDTO = todoEntity.toDto();

        return todoDTO;

    }

    
    @Override
    public TodoDTO modifyTodo(Long id, Boolean isComplete){

        TodoEntity todoEntity = todoDao.modifyTodoEntity(id, isComplete);

        TodoDTO todoDTO = todoEntity.toDto();

        return todoDTO;

    }

    @Override
    public TodoDTO removeTodo(Long id){

        TodoEntity todoEntity = todoDao.removeTodoEntity(id);

        TodoDTO todoDTO = todoEntity.toDto();

        return todoDTO;

    }
}
