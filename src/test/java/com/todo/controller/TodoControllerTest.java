package com.todo.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.todo.dto.TodoDTO;
import com.todo.service.Todo.TodoServiceImpl;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TodoServiceImpl todoService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    
    LocalDateTime startTimeTemplate = LocalDateTime.parse("2023-07-17T11:30", formatter);
    LocalDateTime endTimeTemplate = LocalDateTime.parse("2023-07-17T12:30", formatter);

    LocalDateTime exampleStartDateTime1 = LocalDateTime.parse("2023-07-17T03:30", formatter);
    LocalDateTime exampleStartDateTime2 = LocalDateTime.parse("2023-07-17T09:30", formatter);
    LocalDateTime exampleStartDateTime3 = LocalDateTime.parse("2023-07-17T15:30", formatter);
    LocalDateTime exampleStartDateTime4 = LocalDateTime.parse("2023-07-17T18:30", formatter);

    LocalDateTime exampleEndDateTime1 = LocalDateTime.parse("2023-07-17T04:30", formatter);
    LocalDateTime exampleEndDateTime2 = LocalDateTime.parse("2023-07-17T11:30", formatter);
    LocalDateTime exampleEndDateTime3 = LocalDateTime.parse("2023-07-17T17:30", formatter);
    LocalDateTime exampleEndDateTime4 = LocalDateTime.parse("2023-07-17T21:30", formatter);

    
    // private TodoDTO todoTemplate = TodoDTO.builder().id(0).createdUser(0).title("todo").startTime(startTimeTemplate).endTime(endTimeTemplate).build();

    private TodoDTO exampleTodo1 = TodoDTO.builder().id(1).createdUser(1).title("todo exmaple 1").startTime(exampleStartDateTime1).endTime(exampleEndDateTime1).build();
    private TodoDTO exampleTodo2 = TodoDTO.builder().id(2).createdUser(1).title("todo exmaple 2").startTime(exampleStartDateTime2).endTime(exampleEndDateTime2).build();
    private TodoDTO exampleTodo3 = TodoDTO.builder().id(3).createdUser(2).title("todo exmaple 3").startTime(exampleStartDateTime3).endTime(exampleEndDateTime3).build();
    private TodoDTO exampleTodo4 = TodoDTO.builder().id(4).createdUser(2).title("todo exmaple 4").startTime(exampleStartDateTime4).endTime(exampleEndDateTime4).build();



    @Test 
    @DisplayName("todo list 조회")
    void getTodoTest() throws Exception {

        List<TodoDTO> todoList = new ArrayList<>();

        todoList.add(exampleTodo1);
        todoList.add(exampleTodo2);


        given(todoService.inquireTodo(1L)).willReturn(todoList);

        mockMvc.perform(
            post("/todo/list/1"))
            .andExpect(status().isOk())
            .andDo(print());

        verify(todoService).inquireTodo(1L);

    }

    @Test
    @DisplayName("일정 등록 테스트")
    void postTodoTest() throws Exception {

        /** example 1 테스트 */

        given(todoService.createTodo(
            exampleTodo1.getId(),
            exampleTodo1.getCreatedUser(),
            exampleTodo1.getTitle(),
            exampleTodo1.getStartTime(),
            exampleTodo1.getEndTime(),
            exampleTodo1.getIsComplete())).willReturn(exampleTodo1);

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new com.todo.config.LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        // Gson gson = new Gson();

        

        String content1 = gson.toJson(exampleTodo1);

        mockMvc.perform(
            post("/todo/add").content(content1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        verify(todoService).createTodo(1L, 1L, "todo exmaple 1", exampleStartDateTime1, exampleEndDateTime1, null);

    }


    @Test
    @DisplayName("일정 삭제 테스트")
    void deleteTodoTest() throws Exception {

        /** example 1 테스트 */

        given(todoService.removeTodo(2L)).willReturn(exampleTodo2);

        mockMvc.perform(
            post("/todo/delete/2")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        

        verify(todoService).removeTodo(2L);

    }





    
    
}
