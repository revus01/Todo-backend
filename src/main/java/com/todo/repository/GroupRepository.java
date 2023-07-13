package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.GroupEntity;


public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    
}
