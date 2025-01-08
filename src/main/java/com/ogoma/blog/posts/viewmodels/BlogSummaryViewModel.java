package com.ogoma.blog.posts.viewmodels;

import com.ogoma.blog.posts.entities.PostStatsEntity;
import lombok.Getter;

@Getter
public class BlogSummaryViewModel {
    private long commentCount;
    private long likeCount;
    private long shareCount;

    public BlogSummaryViewModel(PostStatsEntity stats) {
        if (stats != null) {
            this.commentCount = stats.getCommentCount();
            this.likeCount = stats.getLikeCount();
            this.shareCount = stats.getShareCount();
        }
    }
}

