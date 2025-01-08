package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "likes")
public class PostLikeEntity extends BaseEntity {

    @ManyToOne
    private UserEntity likedBy;
    @ManyToOne
    private PostEntity blog;
}
