package com.todo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.LoginDTO;
import com.todo.dto.UserDTO;
import com.todo.service.User.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

        //리스트 항목 출력
    @GetMapping("/list")
    public List<UserDTO> getTodo(){
        return userService.inquireUser();
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO) {
        
        return userService.login(loginDTO.getEmail(), loginDTO.getPassword());
    }



    @PostMapping("/signup")
    public String signup(@RequestBody UserDTO userDTO) {
        return userService.join(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }

    

}
