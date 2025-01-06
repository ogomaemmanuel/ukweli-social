package com.ogoma.blog.content.viewmodels;

import com.ogoma.blog.content.entities.BlogStatsEntity;
import lombok.Getter;

@Getter
public class BlogSummaryViewModel {
    private long commentCount;
    private long likeCount;
    private long shareCount;

    public BlogSummaryViewModel(BlogStatsEntity stats) {
        if (stats != null) {
            this.commentCount = stats.getCommentCount();
            this.likeCount = stats.getLikeCount();
            this.shareCount = stats.getShareCount();
        }
    }
}

