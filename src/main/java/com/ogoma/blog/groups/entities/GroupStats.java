package com.ogoma.blog.groups.entities;

import lombok.Getter;

@Getter
public class GroupStats {
    private long memberCount;
    private long likeCount;
    private long postCount;
    private long totalInvitations;
    private long totalPendingInvitations;
    private long totalJoinRequests;

    public void incrementMemberCount() {
        memberCount++;
    }

    public void incrementLikeCount() {
        likeCount++;
    }

    public void incrementPostCount() {
        postCount++;
    }

    public void incrementTotalJoinRequests() {
        totalJoinRequests++;
    }

}
