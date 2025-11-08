package com.ogoma.blog.posts.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BlogCommentCreateRequest {
    private String comment;
    private UUID parentId;
}
