package com.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/posts/{postsId}")
    public String getPosts(@PathVariable Long postsId) {
        return " performTest postId : ";
    }
    
}
