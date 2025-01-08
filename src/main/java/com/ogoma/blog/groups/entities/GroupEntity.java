package com.ogoma.blog.groups.entities;

import com.ogoma.blog.content.entities.BlogEntity;
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
@Table(name="groups")
public class GroupEntity extends BaseEntity {
    @Setter
    private String name;
    @Setter
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    @Getter
    private GroupStats groupStats;
    @Setter
    @Enumerated(EnumType.STRING)
    private GroupPrivacy privacy;
    @Setter
    //only admins can post other members cannot if isViewOnly
    private boolean viewOnly;
    @Getter
    @ManyToMany(cascade = {CascadeType.MERGE,  CascadeType.PERSIST})
    @JoinTable(name = "group_members_join_tbl")
    private Set<GroupMemberEntity> members = new HashSet<>();
    @Getter
    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy =GroupJoinRequestEntity_.GROUP)
    private Set<GroupJoinRequestEntity> joinRequests = new HashSet<>();

    @Getter
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<BlogEntity> blogs = new HashSet<>();

    public void addMembers(GroupMemberEntity... groupMembers) {
        this.members.addAll(List.of(groupMembers));
        if (groupStats == null) {
            groupStats = new GroupStats();
        }
        for (GroupMemberEntity _ : groupMembers
        ) {
            groupStats.incrementMemberCount();
        }
    }


    public void addPost(BlogEntity groupPostEntity) {
        this.blogs.add(groupPostEntity);
        if (groupStats == null) {
            this.groupStats = new GroupStats();
        }
        groupStats.incrementPostCount();
    }

    public void addJoinRequest(GroupJoinRequestEntity joinRequestEntity) {
        joinRequestEntity.setGroup(this);
        this.joinRequests.add(joinRequestEntity);
        if (groupStats == null) {
            groupStats = new GroupStats();
        }
        this.groupStats.incrementTotalJoinRequests();
    }

    public void addLike(GroupLikeEntity groupLike) {
        groupLike.setGroupEntity(this);
        if (groupStats == null) {
            groupStats = new GroupStats();
        }
        groupStats.incrementLikeCount();
    }

}
