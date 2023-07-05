package com.todo.service.User;

import java.util.List;

import com.todo.dto.UserDTO;

public interface UserService {

    List<UserDTO> inquireUser();
    
    String join(String username, String email, String password);

    UserDTO login(String email, String password);

}
