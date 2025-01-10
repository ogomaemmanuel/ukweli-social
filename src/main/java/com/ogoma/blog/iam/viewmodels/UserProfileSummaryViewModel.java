package com.ogoma.blog.iam.viewmodels;

import com.ogoma.blog.posts.entities.UserProfileStats;
import lombok.Getter;


@Getter
public final class UserProfileSummaryViewModel {
    private  long postCount;
    private  long commentCount;
    private  long followerCount;
    private  long followingCount;
    private  long profileViewCount;

    public UserProfileSummaryViewModel(UserProfileStats profileStats) {
        if (profileStats!=null) {
            this.postCount = profileStats.getPostCount();
            this.commentCount = profileStats.getCommentCount();
            this.followerCount = profileStats.getFollowerCount();
            this.followingCount = profileStats.getFollowingCount();
            this.profileViewCount = profileStats.getProfileViewCount();
        }
    }


}
