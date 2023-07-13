package com.todo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.todo.entity.GroupEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    @NotNull
    private long groupId;

    @NotEmpty
    private long ownerId;

    @NotEmpty
    private String groupName;

    public GroupEntity toEntity() {
        return GroupEntity.builder().groupId(groupId).ownerId(ownerId).groupName(groupName).build();
    }


    
}
