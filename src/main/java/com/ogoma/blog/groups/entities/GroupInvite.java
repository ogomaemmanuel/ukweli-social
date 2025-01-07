package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupInvite extends BaseEntity {
    private UserEntity invitee;
    private GroupEntity groupEntity;
    private boolean isAccepted;
}
