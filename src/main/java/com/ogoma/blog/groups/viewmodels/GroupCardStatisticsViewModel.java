package com.ogoma.blog.groups.viewmodels;

import com.ogoma.blog.groups.entities.GroupStatsEntity;
import lombok.Getter;

@Getter
public class GroupCardStatisticsViewModel {

    public GroupCardStatisticsViewModel(GroupStatsEntity groupStats) {
       this.memberCount= groupStats.getMemberCount();
       this.postCount= groupStats.getPostCount();
       this.totalInvitations= groupStats.getTotalInvitations();
       this.totalPendingInvitations=groupStats.getTotalPendingInvitations();
       this.totalJoinRequests= groupStats.getTotalJoinRequests();
    }
    private final long memberCount;
    private final long postCount;
    private final long totalInvitations;
    private final long totalPendingInvitations;
    private final long totalJoinRequests;
}
