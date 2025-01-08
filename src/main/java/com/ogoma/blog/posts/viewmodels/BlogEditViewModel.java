package com.ogoma.blog.posts.viewmodels;

import com.ogoma.blog.posts.entities.PostEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogEditViewModel {
    private Long id;
    private String title;
    private String content;
    private String systemGeneratedId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public BlogEditViewModel(PostEntity blogEntity) {
        if(blogEntity!=null){
            this.id = blogEntity.getId();
            this.title= blogEntity.getTitle();
            this.content= blogEntity.getContent();
            this.systemGeneratedId= blogEntity.getSystemGeneratedId();
            this.createdAt= blogEntity.getCreatedAt();
            this.updatedAt=blogEntity.getUpdatedAt();
        }
    }


}
