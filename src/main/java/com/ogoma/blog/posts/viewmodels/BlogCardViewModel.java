package com.ogoma.blog.posts.viewmodels;

import com.ogoma.blog.posts.entities.PostEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public  class BlogCardViewModel {

    public BlogCardViewModel(PostEntity blogEntity) {
        this.id = blogEntity.getId();
        this.systemGeneratedId = blogEntity.getSystemGeneratedId();
        this.content = blogEntity.getContent();
        this.title = blogEntity.getTitle();
        this.description = blogEntity.getDescription();
        this.createdAt = blogEntity.getCreatedAt();
        this.updatedAt = blogEntity.getUpdatedAt();
        this.summary = new BlogSummaryViewModel(blogEntity.getStats());
    }
    private final String systemGeneratedId;
    private final Long id;
    private final String title;
    private final String description;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final BlogSummaryViewModel summary;
}
