package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TodoDTO;
import com.todo.service.Todo.TodoService;


@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //리스트 항목 출력
    @PostMapping("/list/{userId}")
    public List<TodoDTO> getTodo(@PathVariable Long userId){
        return todoService.inquireTodo(userId);
    }

    //리스트 항목 추가
    @PostMapping("/add")
    public TodoDTO postTodo(@RequestBody TodoDTO todoDTO){

        return todoService.createTodo(todoDTO.getId(), todoDTO.getCreatedUser(),todoDTO.getTitle(), todoDTO.getStartTime(), todoDTO.getEndTime(), todoDTO.getIsComplete());

    }

    //리스트 항목 상태 변경
    @PutMapping("/change/{id}/{isComplete}")
    public TodoDTO putTodo(@PathVariable Long id, @PathVariable Boolean isComplete){
        return todoService.modifyTodo(id, isComplete);
    }


    //리스트 항목 삭제
    @PostMapping("/delete/{id}")
    public TodoDTO deleteTodo(@PathVariable Long id){
        return todoService.removeTodo(id);
    }

    
    
}
