package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "saved_posts")
public class UserSavedPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ManyToOne
    private PostEntity post;

    @ManyToOne
    private UserEntity user;

}
