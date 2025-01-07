package com.ogoma.blog.groups.viewmodels;

import com.ogoma.blog.groups.entities.GroupEntity;
import com.ogoma.blog.groups.entities.GroupPrivacy;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GroupCardViewModel {
    public GroupCardViewModel(GroupEntity groupEntity) {
        this.name = groupEntity.getName();
        this.description = groupEntity.getDescription();
        this.privacy = groupEntity.getPrivacy();
        this.createdAt = groupEntity.getCreatedAt();
        this.updatedAt = groupEntity.getUpdatedAt();
        this.viewOnly = groupEntity.isViewOnly();
        this.statistics = new GroupCardStatisticsViewModel(groupEntity.getGroupStats());
    }
    private final String name;
    private final String description;
    private final GroupPrivacy privacy;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final boolean viewOnly;
    private final GroupCardStatisticsViewModel statistics;
}
