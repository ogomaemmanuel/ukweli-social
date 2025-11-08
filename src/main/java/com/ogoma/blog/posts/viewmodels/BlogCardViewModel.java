package com.ogoma.blog.posts.viewmodels;

import com.ogoma.blog.posts.entities.PostEntity;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class BlogCardViewModel {

    public BlogCardViewModel(PostEntity blogEntity) {
        this.id = blogEntity.getId().id();
        this.content = blogEntity.getContent();
        this.title = blogEntity.getTitle();
        this.createdAt = blogEntity.getCreatedAt();
        this.updatedAt = blogEntity.getUpdatedAt();
        this.summary = new BlogSummaryViewModel(blogEntity.getStats());
    }

    private final UUID id;
    private final String title;
    private final String content;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final BlogSummaryViewModel summary;
}
