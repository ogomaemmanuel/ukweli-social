package com.ogoma.blog.iam.services;


import com.ogoma.blog.iam.viewmodels.UserCardViewModel;
import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.repositories.UserRepository;
import com.ogoma.blog.iam.viewmodels.UserProfileDetailsViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserProfileDetailsViewModel getUserDetailsByUserId(Long userId) {
        return this.userRepository.findById(userId).map(UserProfileDetailsViewModel::new).orElseThrow(() -> new RecordNotFoundException("User not found with id " + userId));
    }


    @Transactional
    public void followUser(Long userIdToFollow, UserEntity currentUser) {
        this.userRepository.findById(currentUser.getId()).ifPresent(follower -> {
            UserEntity followedUser = this.userRepository.getReferenceById(userIdToFollow);
            followedUser.addFollower(follower);
            this.userRepository.saveAll(List.of(followedUser));
        });
    }

    public void unfollowUser(Long userIdToFollow, UserEntity currentUser) {
        UserEntity followerEntity = new UserEntity();
        UserEntity followedUser = this.userRepository.getReferenceById(userIdToFollow);
        followedUser.removeFollower(followerEntity);
        this.userRepository.save(followedUser);
    }

    public Page<UserCardViewModel> getUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(UserCardViewModel::new);
    }
}
