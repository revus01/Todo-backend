package com.todo.dao.Group;

import java.util.List;

import com.todo.entity.GroupEntity;
import com.todo.entity.UserEntity;

public interface GroupDao {

    List<GroupEntity> getGroups();

    String create(GroupEntity groupEntity);

    String enroll(UserEntity userEntity);

    String dismiss(UserEntity userEntity);
    
}
