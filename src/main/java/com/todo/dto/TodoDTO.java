package com.todo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.todo.entity.TodoEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDTO {

    @NotNull
    private long id;

    @NotEmpty
    private long createdUser;

    @NotEmpty
    private String title;

    @NotEmpty
    private Boolean isComplete;

    @NotEmpty
    private LocalDateTime startTime;

    @NotEmpty
    private LocalDateTime endTime;

    public TodoEntity toEntity(){
        return TodoEntity.builder().id(id).createdUser(createdUser).title(title).startTime(startTime).endTime(endTime).isComplete(isComplete).build();
    }

}
