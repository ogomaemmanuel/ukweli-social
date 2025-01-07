package com.ogoma.blog.content.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class BlogLike extends BaseEntity {

    @ManyToOne
    private UserEntity likedBy;
    @ManyToOne
    private BlogEntity blog;
}
