package com.todo.dao.User;

import java.util.List;

import com.todo.entity.UserEntity;

public interface UserDao {
    
    String join(String username, String email, String password);

    List<UserEntity> inquireUser();

    UserEntity login(String emaail);

}
