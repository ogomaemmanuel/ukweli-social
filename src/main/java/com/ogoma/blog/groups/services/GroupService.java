package com.ogoma.blog.groups.services;

import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.entities.GroupEntity;
import com.ogoma.blog.groups.entities.GroupMemberEntity;
import com.ogoma.blog.groups.entities.GroupRole;
import com.ogoma.blog.groups.repository.GroupRepository;
import com.ogoma.blog.iam.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(GroupCreateRequestDto createRequestDto, UserEntity userEntity) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setDescription(createRequestDto.getDescription());
        groupEntity.setName(createRequestDto.getName());
        groupEntity.setViewOnly(createRequestDto.isViewOnly());
        GroupMemberEntity groupMemberEntity = new GroupMemberEntity();
        groupMemberEntity.setUserEntity(userEntity);
        groupMemberEntity.setMembershipRole(GroupRole.ADMIN);
        groupEntity.addMembers(groupMemberEntity);
        this.groupRepository.save(groupEntity);
    }
}
