package com.ogoma.blog.posts.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private PostVisibility visibility;
    @JdbcTypeCode(SqlTypes.JSON)
    @Setter
    private Set<String> medialUrls;
    @Setter
    private String description;
    //https://learn.microsoft.com/en-us/ef/core/performance/efficient-querying
    // lazy load to many relations to avoid cartesian explosion when loading related entities
    @OneToMany
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
    @Setter
    private boolean forGroup;

    public void addComment(PostCommentsEntity comment) {
        //if the comments are a set, this will lead to a call to the db fetching all the records
        // https://vladmihalcea.com/set-bidirectional-onetomany/

        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        // Initialize the collection explicitly
        this.comments.add(comment);
        comment.setBlog(this);
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

    public void addLike(PostLikeEntity like) {
        likes.add(like);
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
