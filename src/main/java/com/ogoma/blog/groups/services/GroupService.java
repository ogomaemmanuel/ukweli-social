package com.ogoma.blog.groups.services;

import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.entities.*;
import com.ogoma.blog.groups.repository.GroupRepository;
import com.ogoma.blog.groups.viewmodels.GroupCardViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.posts.dto.BlogCreateRequest;
import com.ogoma.blog.posts.entities.PostEntity;
import jakarta.persistence.EntityNotFoundException;
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
        GroupEntity groupEntity = GroupEntity.createNew(
                createRequestDto.getName(),
                createRequestDto.getDescription(),
                createRequestDto.getPrivacy(),
                createRequestDto.isViewOnly());
        GroupMemberEntity groupMemberEntity = GroupMemberEntity.createNew(userEntity.getId(),GroupRole.ADMIN);
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

    @Transactional
    public void likeGroup(GroupID groupId, UserEntity currentUser) {
        GroupLikeEntity groupLike = new GroupLikeEntity();
        groupLike.setLikedBy(currentUser);
        GroupEntity group = this.groupRepository.getReferenceById(groupId);
        group.addLike(groupLike);
        this.groupRepository.save(group);
    }

    @Transactional
    public void postToGroup(GroupID groupId, UserEntity currentUser, BlogCreateRequest blogCreateRequest) {
        PostEntity postEntity= PostEntity.createNewPost(
                blogCreateRequest.getTitle(),
                blogCreateRequest.getContent(),
                blogCreateRequest.getVisibility(),
                blogCreateRequest.getMediaUrls(),
                true
                );
        GroupEntity group = groupRepository.getReferenceById(groupId);
        group.addPost(postEntity);
        this.groupRepository.save(group);
    }

    @Transactional
    public void addJoinRequest(GroupID groupId, UserEntity currentUser) {
        try {
            GroupEntity group = this.groupRepository.getReferenceById(groupId);
            GroupJoinRequestEntity joinRequestEntity = new GroupJoinRequestEntity();
            joinRequestEntity.setRequestBy(currentUser);
            group.addJoinRequest(joinRequestEntity);
            this.groupRepository.save(group);
        }catch (EntityNotFoundException entityNotFoundException){
            throw  new RecordNotFoundException("No  group with id %d".formatted(groupId));
        }
        // group.
    }
}
