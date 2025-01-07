package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;

public class GroupJoinRequestEntity extends BaseEntity {
    private GroupEntity groupEntity;
    private UserEntity userEntity;
    private boolean accepted;
}
