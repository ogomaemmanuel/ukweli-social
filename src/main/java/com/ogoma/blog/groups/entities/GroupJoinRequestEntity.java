package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "group_join_requests")
public class GroupJoinRequestEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne()
    private GroupEntity group;
    @ManyToOne
    private UserEntity requestBy;
    private boolean accepted;
}
