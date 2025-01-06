package com.ogoma.blog.content.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreateRequest {
    private String title;
    private String content;
}
