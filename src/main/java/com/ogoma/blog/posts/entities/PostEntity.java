package com.ogoma.blog.posts.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserID;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Getter
@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {

    @EmbeddedId
    private final PostID id;


    private String title;

    private String content;

    private PostVisibility visibility;
    @JdbcTypeCode(SqlTypes.JSON)
    private Set<String> medialUrls;
    //https://learn.microsoft.com/en-us/ef/core/performance/efficient-querying
    // lazy load to many relations to avoid cartesian explosion when loading related entities
    @OneToMany(mappedBy = "blog")
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    private List<PostLikeEntity> likes = new ArrayList<>();
    @OneToMany(orphanRemoval = true, mappedBy = "blog")
    @Cascade({CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.PERSIST})
    private List<PostCommentsEntity> comments = new ArrayList<>();
    @OneToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    private PostStatsEntity stats;
    @Enumerated(EnumType.STRING)
    private PostPublicationStatus status = PostPublicationStatus.DRAFT;
    @Setter
    private boolean forGroup;


    protected PostEntity() {
        super();
        this.id = new PostID();
    }

    private PostEntity(String title,
                       String content,
                       PostVisibility postVisibility,
                       Set<String> medialUrls,
                       boolean forGroup
    ) {
        this();
        this.title = title;
        this.content = content;
        this.visibility = postVisibility;
        this.medialUrls = medialUrls;
        this.forGroup=forGroup;
    }

    public static PostEntity createNewPost(
            String title,
            String content,
            PostVisibility postVisibility,
            Set<String> medialUrls,
            boolean forGroup
    ) {
        return new PostEntity(
                title,
                content,
                postVisibility,
                medialUrls,
                forGroup
        );
    }


    public void addComment(
            String comment,
            UUID parentId,
            UserID commentBy) {
        //if the comments are a set, this will lead to a call to the db fetching all the records
        // https://vladmihalcea.com/set-bidirectional-onetomany/

        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }


        var postComment=PostCommentsEntity.createNew(comment,parentId==null?null: new PostCommentsID(parentId),this,commentBy);
        // Initialize the collection explicitly
        this.comments.add(postComment);
        if (this.stats == null) {
            stats = new PostStatsEntity();
        }
        stats.incrementCommentCount();
    }

    public void removeComment(PostCommentsEntity comment) {
        if (this.comments == null) {
            comments = new ArrayList<>();
        }
        if (this.stats == null) {
            stats = new PostStatsEntity();
        }
        comments.remove(comment);
        comment.setBlog(null);
        stats.decrementCommentCount();
    }

    public void addLike(UserEntity user) {
        PostLikeEntity blogLike = new PostLikeEntity();
        blogLike.setCreatedAt(Instant.now());
        blogLike.setUpdatedAt(Instant.now());
        blogLike.setLikedBy(user);
        blogLike.setBlog(this);
        likes.add(blogLike);
        if (this.stats == null) {
            stats = new PostStatsEntity();
        }
        stats.incrementLikeCount();
    }

    public void removeLike(PostLikeEntity like) {
        likes.remove(like);
        if (this.stats != null) {
            stats.decrementLikeCount();
        }
    }


}
