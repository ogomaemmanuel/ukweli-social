package com.ogoma.blog.groups.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class GroupEntity extends BaseEntity {
    @Setter
    private String name;
    @Setter
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    @Getter
    private GroupStatsEntity groupStats;
    @Setter
    @Enumerated(EnumType.STRING)
    private GroupPrivacy privacy;
    @Setter
    //only admins can post other members cannot if isViewOnly
    private boolean viewOnly;
    @Getter
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<GroupMemberEntity> members = new HashSet<>();

    public void addMembers(GroupMemberEntity... groupMembers) {
        this.members.addAll(List.of(groupMembers));
        if (groupStats == null) {
            groupStats = new GroupStatsEntity();
        }
        for (GroupMemberEntity _ : groupMembers
        ) {
            groupStats.incrementMemberCount();
        }
    }

}
