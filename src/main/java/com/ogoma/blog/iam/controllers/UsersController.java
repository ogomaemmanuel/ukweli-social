package com.ogoma.blog.iam.controllers;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.services.UserService;
import com.ogoma.blog.iam.viewmodels.UserProfileDetailsViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileDetailsViewModel> getLoggedUserDetails(@AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.ok(this.userService.getUserDetailsByUserId(user.getId()));
    }

    @PostMapping("/{userId}/follow")
    public ResponseEntity<Void> follow(@PathVariable Long userId, @AuthenticationPrincipal UserEntity user) {
        this.userService.followUser(userId, user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/unfollow")
    public ResponseEntity<Void> unfollow(@PathVariable Long userId, @AuthenticationPrincipal UserEntity user) {
        this.userService.unfollowUser(userId, user);
        return ResponseEntity.ok().build();
    }


}
