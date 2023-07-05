package com.todo.dao.Todo;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity;
import com.todo.repository.TodoRepository;

@Service
public class TodoDaoImpl implements TodoDao {
    
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<TodoEntity> inquireTodoEntity(Long uid) {
        return todoRepository.findByCreatedUser(uid);
    }

    @Override
    public TodoEntity createTodoEntity(Long createdUser, String title, LocalDateTime startTime, LocalDateTime endTime, Boolean isComplete) {
        
        TodoEntity todoEntity = new TodoEntity();

        todoEntity.setCreatedUser(createdUser);
        todoEntity.setTitle(title);
        todoEntity.setStartTime(startTime);
        todoEntity.setEndTime(endTime);
        todoEntity.setIsComplete(isComplete);

        todoRepository.save(todoEntity);

        return todoEntity;
    }

    @Override
    @Transactional
    public TodoEntity modifyTodoEntity(Long id, Boolean isComplete) {

        TodoEntity todoEntity = todoRepository.getReferenceById(id);

        todoEntity.setIsComplete(isComplete);

        todoRepository.save(todoEntity);

        return todoEntity;
    }

    @Override
    @Transactional
    public TodoEntity removeTodoEntity(Long id){
        
        TodoEntity todoEntity = todoRepository.getReferenceById(id);

        todoRepository.deleteById(id);

        return todoEntity;
    }
}
