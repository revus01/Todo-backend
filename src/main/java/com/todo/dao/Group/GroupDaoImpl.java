package com.todo.dao.Group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.GroupEntity;
import com.todo.entity.UserEntity;
import com.todo.repository.GroupRepository;
import com.todo.repository.UserRepository;

@Service
public class GroupDaoImpl implements GroupDao {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public List<GroupEntity> getGroups() {

        return groupRepository.findAll();

    }

    public String create(GroupEntity groupEntity) {

        groupRepository.save(groupEntity);

        return "success";
    }

    public String enroll(UserEntity userEntity) {

        userRepository.save(userEntity);

        return "enrolled";

    }

    public String dismiss(UserEntity userEntity) {

        userRepository.save(userEntity);

        return "dismissed";

    }
    
}
