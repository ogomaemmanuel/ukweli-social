package com.ogoma.blog.content.viewmodels;

import com.ogoma.blog.content.entities.BlogEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class BlogCardViewModel {

    public BlogCardViewModel(BlogEntity blogEntity) {
        this.content = blogEntity.getContent();
        this.title = blogEntity.getTitle();
        this.description = blogEntity.getDescription();
        this.createdAt = blogEntity.getCreatedAt();
        this.updatedAt = blogEntity.getUpdatedAt();
        this.summary= new BlogSummaryViewModel(blogEntity.getStats());
    }

    private String title;
    private String description;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BlogSummaryViewModel summary;
}
