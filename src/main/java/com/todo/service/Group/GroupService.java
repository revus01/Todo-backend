package com.todo.service.Group;

import java.util.List;

import com.todo.dto.GroupDTO;
import com.todo.dto.GroupRequestDTO;

public interface GroupService {

    List<GroupDTO> getGroups();

    String getMembers(Long groupId);

    String create(GroupDTO groupDTO);

    String dissolve(GroupRequestDTO requestDTO);

    String enroll(GroupRequestDTO requestDTO);

    String dismiss(GroupRequestDTO requestDTO);
    
}
