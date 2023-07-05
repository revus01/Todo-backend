package com.todo.dao.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.UserEntity;
import com.todo.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> inquireUser() {
        return userRepository.findAll();
    }

    @Override
    public String join(String username, String email, String password){
        
        UserEntity userEntity = UserEntity.builder().username(username).email(email).password(password).build();

        userRepository.save(userEntity);

        return "success";


    }

    @Override
    public UserEntity login(String email) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(email);
        UserEntity userEntity = optionalUserEntity.get();

        return userEntity;
    }
}
