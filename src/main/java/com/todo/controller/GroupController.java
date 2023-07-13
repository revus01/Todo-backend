package com.todo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.GroupDTO;
import com.todo.dto.GroupRequestDTO;
import com.todo.service.Group.GroupService;



@RestController
@RequestMapping("/group")
public class GroupController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GroupService groupService;

    @GetMapping("/list")
    public List<GroupDTO> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/members")
    public String getMembers(@RequestParam("groupId") Long groupId  ) {
        return groupService.getMembers(groupId);
    }
    
    @PostMapping("/create")
    public String create(@RequestBody GroupDTO groupDTO) {
        logger.warn(groupDTO.toString());
        return groupService.create(groupDTO);
    }

    @PostMapping("/dissolve")
    public String disssolve(@RequestBody GroupRequestDTO requestDTO ) {
        return groupService.dissolve(requestDTO);
    }

    @PostMapping("/enroll")
    public String enroll(@RequestBody GroupRequestDTO requestDTO ) {
        return groupService.enroll(requestDTO);
    }

    @PostMapping("/dismiss")
    public String dismiss(@RequestBody GroupRequestDTO requestDTO) {
        return groupService.dismiss(requestDTO);
    }


}
