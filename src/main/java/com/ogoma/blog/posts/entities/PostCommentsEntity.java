package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class PostCommentsEntity {

    @EmbeddedId
    PostCommentsID id;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false, name = "parent_id")
    private PostCommentsEntity parent;
    @AttributeOverride(name = "id", column = @Column(name = "parent_id"))
    @Column(name ="parent_id" )
    private PostCommentsID parentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private PostEntity blog;
    @AttributeOverride(name = "id", column = @Column(name = "created_by"))
    @Embedded
    private UserID createdBy;
    private Instant createdAt;
    private Instant updatedAt;


    protected PostCommentsEntity() {
        this.id = new PostCommentsID();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    private PostCommentsEntity(String comment,
                               PostCommentsID parentId,
                               PostEntity post,
                               UserID commentBy
    ) {
        this();
        this.comment = comment;
        this.parentId = parentId;
        this.blog = post;
        this.createdBy = commentBy;
    }

    public static PostCommentsEntity createNew(String comment,
                                               PostCommentsID parentId,
                                               PostEntity post,
                                               UserID commentBy
    ) {
        return new PostCommentsEntity(comment, parentId, post, commentBy);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentsEntity comment = (PostCommentsEntity) o;
        return Objects.equals(this.getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
