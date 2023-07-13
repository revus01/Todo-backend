package com.todo.testing;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLifeCycle {
    
    @BeforeAll
    static void beforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }
    
    @AfterAll
    static void afterAll() {
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();
    }
    
    @BeforeEach
    void beforeEach() {
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }
    
    @AfterEach
    void afterEach() {
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();
    }
    
    @Test
    public void test() {
        System.out.println("## test 시작 ##");
        System.out.println();
    }

    @Test
    public void test2() {
        System.out.println("## test2 시작 ##");
        System.out.println();
    }
}
