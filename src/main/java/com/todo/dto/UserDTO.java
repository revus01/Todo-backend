package com.todo.dto;

import javax.validation.constraints.NotBlank;

import com.todo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long uid;

    @NotBlank
    private String username;
    
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private Long affiliation;

    public UserEntity toEntity() {
        return UserEntity.builder().uid(uid).username(username).email(email).password(password).affiliation(affiliation).build();
    }

    

    
    
}
