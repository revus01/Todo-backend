package com.todo.service.User;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.User.UserDao;
import com.todo.dto.UserDTO;
import com.todo.entity.UserEntity;
import com.todo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired 
    UserDao userDao;

    @Override
    public List<UserDTO> inquireUser() {

        List<UserEntity> entityList = userDao.inquireUser();

        List<UserDTO> dtoList =  entityList.stream().map(UserEntity::toDTO).collect(Collectors.toList());

        return dtoList;

        
    }

    @Override
    public String join(String username, String email, String password) {
        
        //중복되는 이메일이 있는지 확인
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new RuntimeException(email + "은 이미 사용된 이메일입니다.");
                });

        userDao.join(username, email, password);
        

        return "success";
    }

    @Override
    public UserDTO login(String email, String password) throws RuntimeException{

        if(userRepository.existsByEmail(email)){

            UserEntity userEntity = userDao.login(email);

            if(userEntity.getPassword().equals(password)){

                UserDTO userDTO = userEntity.toDTO();

                return userDTO;

            }else{

                throw new RuntimeException();

            }

        }else{

            throw new RuntimeException();

        }   

    }

}
