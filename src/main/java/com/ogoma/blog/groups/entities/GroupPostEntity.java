package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.posts.entities.PostEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name="group_posts")
public class GroupPostEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @ManyToOne
    private GroupEntity group;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private UserEntity postedBy;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private PostEntity blog;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
