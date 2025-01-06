package com.ogoma.blog.content.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCommentCreateRequest {
    private String comment;
    private Long parentId;
}
