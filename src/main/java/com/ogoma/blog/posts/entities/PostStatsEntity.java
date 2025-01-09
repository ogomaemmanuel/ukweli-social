package com.ogoma.blog.posts.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "blog_stats")
public class PostStatsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private long commentCount;
    private long likeCount;
    private long shareCount;

    public void incrementCommentCount() {
        commentCount++;
    }

    public void incrementLikeCount() {
        likeCount++;
    }

    public void incrementShareCount() {
        shareCount++;
    }

    public void decrementLikeCount() {
        if (likeCount > 0) likeCount--;
    }

    public void decrementCommentCount() {
        if (commentCount > 0) this.commentCount--;
    }
}
