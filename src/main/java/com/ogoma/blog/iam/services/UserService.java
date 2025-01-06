package com.ogoma.blog.iam.services;


import com.ogoma.blog.content.entities.FollowerEntity;
import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.repositories.UserRepository;
import com.ogoma.blog.iam.viewmodels.UserProfileDetailsViewModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserProfileDetailsViewModel getUserDetailsByUserId(Long userId) {
        return this.userRepository.findById(userId).map(UserProfileDetailsViewModel::new).orElseThrow(() -> new RecordNotFoundException("User not found with id " + userId));
    }

    public void followUser(Long userIdToFollow, UserEntity currentUser) {
        FollowerEntity followerEntity = new FollowerEntity();
        followerEntity.setFollower(currentUser);
        UserEntity followedUser = this.userRepository.getReferenceById(userIdToFollow);
        followedUser.addFollower(followerEntity);
        this.userRepository.save(followedUser);
    }

    public void unfollowUser(Long userIdToFollow, UserEntity currentUser) {
        FollowerEntity followerEntity = new FollowerEntity();
        followerEntity.setFollower(currentUser);
        UserEntity followedUser = this.userRepository.getReferenceById(userIdToFollow);
        followedUser.removeFollower(followerEntity);
        this.userRepository.save(followedUser);
    }

}
