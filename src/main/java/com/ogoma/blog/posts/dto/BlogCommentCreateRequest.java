package com.ogoma.blog.posts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCommentCreateRequest {
    private String comment;
    private Long parentId;
}
