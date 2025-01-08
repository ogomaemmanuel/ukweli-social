package com.ogoma.blog.content.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class BlogCommentsEntity extends BaseEntity {
    private String comment;
    @ManyToOne()
    @JoinColumn(updatable = false, insertable = false, name = "parent_id")
    private BlogCommentsEntity parent;
    @Column(name = "parent_id")
    private Long parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogCommentsEntity comment = (BlogCommentsEntity) o;
        return Objects.equals(this.getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
