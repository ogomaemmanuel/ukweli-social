package com.ogoma.blog.content.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class BlogStatsEntity {
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
