package com.todo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo.dto.TodoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "todos")
public class TodoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long createdUser;
    String title;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Boolean isComplete;

    public TodoDTO toDto() {
        return TodoDTO.builder().id(id).createdUser(createdUser).title(title).startTime(startTime).endTime(endTime).isComplete(isComplete).build();
    }

}
