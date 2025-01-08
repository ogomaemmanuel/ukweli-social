package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "group_members")
public class GroupMemberEntity extends BaseEntity {
    @ManyToOne
    private UserEntity userEntity;
    @Enumerated(EnumType.STRING)
    private GroupRole membershipRole;
}
