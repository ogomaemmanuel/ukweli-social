package com.ogoma.blog.content.dto;

import com.ogoma.blog.content.entities.PostVisibility;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BlogCreateRequest {
    private String title;
    private String content;
    private Set<String> mediaUrls;
    public PostVisibility visibility;

}
