package com.todo.service.Group;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.Group.GroupDao;
import com.todo.dto.GroupDTO;
import com.todo.dto.GroupRequestDTO;
import com.todo.entity.GroupEntity;
import com.todo.entity.UserEntity;
import com.todo.repository.UserRepository;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDao groupDao;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<GroupDTO> getGroups() { 

        List<GroupEntity> groupEntities = groupDao.getGroups();

        List<GroupDTO> dtoList =  groupEntities.stream().map(GroupEntity::toDto).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public String getMembers(Long groupId) { 
        return "members";
    }

    @Override
    public String create(GroupDTO groupDTO) {
        return groupDao.create(groupDTO.toEntity());
    }

    @Override
    public String dissolve(GroupRequestDTO requestDTO) {
        return "dissolved";
    }

    @Override
    public String enroll(GroupRequestDTO requestDTO) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(requestDTO.getUserId());
        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setAffiliation(requestDTO.getGroupId());

        return groupDao.enroll(userEntity);
    }

    @Override
    public String dismiss(GroupRequestDTO requestDTO) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(requestDTO.getUserId());
        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setAffiliation(null);

        return groupDao.dismiss(userEntity);

    }
    
}
