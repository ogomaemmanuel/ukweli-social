package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupMemberEntity extends BaseEntity {
    @ManyToOne
    private UserEntity userEntity;
    @Enumerated(EnumType.STRING)
    private GroupRole membershipRole;
}
