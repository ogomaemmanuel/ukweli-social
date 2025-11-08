package com.ogoma.blog.posts.viewmodels;

import com.ogoma.blog.posts.entities.PostEntity;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class BlogEditViewModel {
    private UUID id;
    private String title;
    private String content;
    private String systemGeneratedId;
    private Instant createdAt;
    private Instant updatedAt;

    public BlogEditViewModel(PostEntity blogEntity) {
        if (blogEntity != null) {
            this.id = blogEntity.getId().id();
            this.title = blogEntity.getTitle();
            this.content = blogEntity.getContent();
            this.createdAt = blogEntity.getCreatedAt();
            this.updatedAt = blogEntity.getUpdatedAt();
        }
    }


}
