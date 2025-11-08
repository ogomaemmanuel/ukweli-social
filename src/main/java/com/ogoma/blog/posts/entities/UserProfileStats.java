package com.ogoma.blog.posts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
public class UserProfileStats implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private long postCount;
    private long commentCount;
    private long followerCount;
    private long followingCount;
    private long profileViewCount;
    private long averageRating;
    private long ratingCount;
    private long roleCount;
    private long noticationCount;

    public void incrementNoticationCount() {
        noticationCount++;
    }

    public void decrementNoticationCount() {
        if (noticationCount > 0) noticationCount--;
    }


    public void incrementFollowing() {
        followingCount++;
    }

    public void decrementFollowing() {
        if (followingCount > 0)
            followingCount--;
    }

    public void incrementFollowerCount() {
        followerCount++;
    }

    public void decrementFollowerCount() {
        if (followingCount > 0) followerCount--;
    }
}
