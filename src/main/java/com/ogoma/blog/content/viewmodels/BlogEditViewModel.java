package com.ogoma.blog.content.viewmodels;

import com.ogoma.blog.content.entities.BlogEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class BlogEditViewModel {
    private Long id;
    private String title;
    private String content;
    private String systemGeneratedId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public BlogEditViewModel(BlogEntity blogEntity) {
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
