package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "followers")
public class FollowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private UserEntity user;


    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private UserEntity follower;
}
