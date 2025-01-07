package com.ogoma.blog.groups.services;

import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.entities.GroupEntity;
import com.ogoma.blog.groups.entities.GroupEntity_;
import com.ogoma.blog.groups.entities.GroupMemberEntity;
import com.ogoma.blog.groups.entities.GroupRole;
import com.ogoma.blog.groups.repository.GroupRepository;
import com.ogoma.blog.groups.viewmodels.GroupCardStatisticsViewModel;
import com.ogoma.blog.groups.viewmodels.GroupCardViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Transactional
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

    public Page<GroupCardViewModel> getGroups(Pageable pageable) {

        return this.groupRepository.findAll((root, _, criteriaBuilder) -> {
            root.fetch(GroupEntity_.CREATED_BY, JoinType.LEFT);
            root.fetch(GroupEntity_.LAST_MODIFIED_BY, JoinType.LEFT);
            return criteriaBuilder.conjunction();
        }, pageable).map(GroupCardViewModel::new);
    }
}
