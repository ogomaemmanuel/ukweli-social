package com.ogoma.blog.content.controllers;

import com.ogoma.blog.content.dto.BlogCommentCreateRequest;
import com.ogoma.blog.content.dto.BlogCreateRequest;
import com.ogoma.blog.content.services.BlogService;
import com.ogoma.blog.content.viewmodels.BlogCardViewModel;
import com.ogoma.blog.content.viewmodels.BlogEditViewModel;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRestController {

    private final BlogService blogService;

    public BlogRestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogEditViewModel> createBlog(@RequestBody @Valid BlogCreateRequest createViewModel) {
        return ResponseEntity.ok(this.blogService.createBlog(createViewModel));
    }

    @GetMapping
    public ResponseEntity<Page<BlogCardViewModel>> getBlogs(Pageable pageable){
      Page<BlogCardViewModel> blogs=  this.blogService.getBlogs(pageable);
      return ResponseEntity.ok(blogs);
    }

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long blogId, @RequestBody @Valid BlogCommentCreateRequest commentCreateRequest) {
        this.blogService.addComment(blogId, commentCreateRequest);
        return ResponseEntity.ok().build();
    }



}
