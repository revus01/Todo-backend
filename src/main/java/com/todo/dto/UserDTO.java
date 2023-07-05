package com.todo.dto;

import javax.validation.constraints.NotNull;

import com.todo.entity.UserEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    @NotNull
    private long uid;

    @NotNull
    private String username;
    
    @NotNull
    private String email;

    @NotNull
    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder().uid(uid).username(username).email(email).password(password).build();
    }

    

    
    
}
