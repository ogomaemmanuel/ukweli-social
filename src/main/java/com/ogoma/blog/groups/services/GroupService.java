package com.ogoma.blog.groups.services;

import com.ogoma.blog.content.dto.BlogCreateRequest;
import com.ogoma.blog.content.entities.BlogEntity;
import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.entities.*;
import com.ogoma.blog.groups.repository.GroupRepository;
import com.ogoma.blog.groups.viewmodels.GroupCardViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
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

    @Transactional
    public void likeGroup(Long groupId, UserEntity currentUser) {
        GroupLikeEntity groupLike = new GroupLikeEntity();
        groupLike.setLikedBy(currentUser);
        GroupEntity group = this.groupRepository.getReferenceById(groupId);
        group.addLike(groupLike);
        this.groupRepository.save(group);
    }

    @Transactional
    public void postToGroup(Long groupId, UserEntity currentUser, BlogCreateRequest blogCreateRequest) {
        BlogEntity blog = new BlogEntity();
        blog.setContent(blogCreateRequest.getContent());
        blog.setMedialUrls(blogCreateRequest.getMediaUrls());
        blog.setTitle(blogCreateRequest.getTitle());
        blog.setForGroup(true);
        blog.setVisibility(blogCreateRequest.getVisibility());
        GroupEntity group = groupRepository.getReferenceById(groupId);
        group.addPost(blog);
        this.groupRepository.save(group);
    }

    @Transactional
    public void addJoinRequest(Long groupId, UserEntity currentUser) {
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
