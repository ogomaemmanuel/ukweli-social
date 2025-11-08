package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "followers")
public class FollowerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private UserEntity user;


    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private UserEntity follower;
}
