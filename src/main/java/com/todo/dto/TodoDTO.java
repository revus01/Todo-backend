package com.todo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.todo.entity.TodoEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDTO {

    @NotNull
    private long id;

    @NotNull
    private long createdUser;

    @NotNull
    private String title;

    // @NotNull
    // private String content;

    @NotNull
    private Boolean isComplete;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    public TodoEntity toEntity(){
        return TodoEntity.builder().id(id).createdUser(createdUser).title(title).startTime(startTime).endTime(endTime).isComplete(isComplete).build();
    }

}
