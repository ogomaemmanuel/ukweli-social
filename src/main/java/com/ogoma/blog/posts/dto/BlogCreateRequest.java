package com.ogoma.blog.posts.dto;

import com.ogoma.blog.posts.entities.PostPublicationStatus;
import com.ogoma.blog.posts.entities.PostVisibility;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BlogCreateRequest {
    private String title;
    private String content;
    private Set<String> mediaUrls;
    private PostVisibility visibility;
    private PostPublicationStatus publicationStatus;

}
