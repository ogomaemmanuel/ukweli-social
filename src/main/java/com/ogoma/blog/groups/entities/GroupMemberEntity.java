package com.ogoma.blog.groups.entities;
import com.ogoma.blog.iam.entities.UserID;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "group_members")
public class GroupMemberEntity extends BaseEntity {
    @EmbeddedId
    private GroupMemberID id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserID userID;
    @Enumerated(EnumType.STRING)
    private GroupRole membershipRole;
    protected GroupMemberEntity() {
        super();
        id = new GroupMemberID();
    }
    private GroupMemberEntity(UserID userID, GroupRole memberRole) {
        this();
        this.userID = userID;
        this.membershipRole = memberRole;
    }
    public static GroupMemberEntity createNew(
            UserID userID,
            GroupRole membershipRole
    ) {
        return new GroupMemberEntity(userID, membershipRole);
    }
}
