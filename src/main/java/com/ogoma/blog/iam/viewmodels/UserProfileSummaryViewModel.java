package com.ogoma.blog.iam.viewmodels;

import com.ogoma.blog.content.entities.UserProfileStats;
import lombok.Getter;


@Getter
public final class UserProfileSummaryViewModel {
    private final long postCount;
    private final long commentCount;
    private final long followerCount;
    private final long followingCount;
    private final long profileViewCount;

    public UserProfileSummaryViewModel(UserProfileStats profileStats) {
        this.postCount = profileStats.getPostCount();
        this.commentCount = profileStats.getCommentCount();
        this.followerCount = profileStats.getFollowerCount();
        this.followingCount = profileStats.getFollowingCount();
        this.profileViewCount = profileStats.getProfileViewCount();
    }


}
