package com.ogoma.blog.content.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BlogCommentsEntity extends BaseEntity {
    private String comment;
    @ManyToOne()
    @JoinColumn(updatable = false, insertable = false, name = "parent_id")
    private BlogCommentsEntity parent;
    @Column(name = "parent_id")
    private Long parentId;
}
