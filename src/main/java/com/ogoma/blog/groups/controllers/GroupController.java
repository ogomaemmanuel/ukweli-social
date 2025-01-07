package com.ogoma.blog.groups.controllers;

import com.ogoma.blog.groups.dto.GroupCreateRequestDto;
import com.ogoma.blog.groups.services.GroupService;
import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/groups")
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
}
