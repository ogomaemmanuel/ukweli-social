package com.ogoma.blog.groups.entities;

import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "groups")
public class GroupEntity extends BaseEntity {
    @EmbeddedId
    private final GroupID id;
    private String name;
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    @Getter
    private GroupStats groupStats;
    @Enumerated(EnumType.STRING)
    private GroupPrivacy privacy;
    //only admins can post other members cannot if isViewOnly
    private boolean viewOnly;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "group_members_join_tbl")
    private final List<GroupMemberEntity> members;
    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = GroupJoinRequestEntity_.GROUP)
    private List<GroupJoinRequestEntity> joinRequests;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private final List<PostEntity> blogs;

    protected GroupEntity() {
        super();
        this.id = new GroupID();
        members = new ArrayList<>();
        blogs = new ArrayList<>();
        joinRequests = new ArrayList<>();
    }

    private GroupEntity(
            String name,
            String description,
            GroupPrivacy privacy,
            boolean viewOnly
    ) {
        this();
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.viewOnly = viewOnly;
    }


    public static GroupEntity createNew(
            String name,
            String description,
            GroupPrivacy privacy,
            boolean viewOnly
            ) {
        return new GroupEntity(name,description,privacy,viewOnly);
    }


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


    public void addPost(PostEntity groupPostEntity) {
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
