package com.ogoma.blog.groups.controllers;

import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.entities.GroupID;
import com.ogoma.blog.groups.services.GroupService;
import com.ogoma.blog.groups.viewmodels.GroupCardViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.posts.dto.BlogCreateRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/groups")
@PreAuthorize(value = "isAuthenticated()")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody @Valid GroupCreateRequestDto createGroupRequestDto, @AuthenticationPrincipal UserEntity userEntity) {
        this.groupService.createGroup(createGroupRequestDto, userEntity);
        return ResponseEntity.ok("Group created");
    }

    @PostMapping("/{groupId}/likes")
    public ResponseEntity<Void> likeGroup(@PathVariable UUID groupId, @AuthenticationPrincipal UserEntity currentUser) {
        this.groupService.likeGroup(new GroupID(groupId), currentUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<GroupCardViewModel>> getGroups(Pageable pageable) {
        return ResponseEntity.ok(this.groupService.getGroups(pageable));
    }

    @PostMapping("/{groupId}/posts")
    public ResponseEntity<Void> postToGroup(@PathVariable UUID groupId,
                                            BlogCreateRequest blogCreateRequest,
                                            @AuthenticationPrincipal UserEntity currentUser) {
        this.groupService.postToGroup(new GroupID(groupId), currentUser, blogCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{groupId}/join-requests")
    public ResponseEntity<Void> requestToJoinGroup(@PathVariable UUID groupId,
                                                   @AuthenticationPrincipal UserEntity userEntity) {
        this.groupService.addJoinRequest(new GroupID(groupId), userEntity);
        return ResponseEntity.ok().build();
    }
}
