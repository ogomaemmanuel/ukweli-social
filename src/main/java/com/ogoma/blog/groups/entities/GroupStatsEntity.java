package com.ogoma.blog.groups.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class GroupStatsEntity {
    private Long id;
    private long memberCount;
    private long postCount;
    private long totalInvitations;
    private long totalPendingInvitations;
    private long totalJoinRequests;

    public void incrementMemberCount(){
        memberCount++;
    }

}
