package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "group_invites")
public class GroupInvite extends BaseEntity {
    private UserEntity invitee;
    private GroupEntity groupEntity;
    private boolean isAccepted;
}
