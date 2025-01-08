package com.ogoma.blog.posts.controllers;

import com.ogoma.blog.posts.dto.BlogCommentCreateRequest;
import com.ogoma.blog.posts.dto.BlogCreateRequest;
import com.ogoma.blog.posts.services.PostsService;
import com.ogoma.blog.posts.viewmodels.BlogCardViewModel;
import com.ogoma.blog.posts.viewmodels.BlogEditViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
@PreAuthorize("isFullyAuthenticated()")
public class PostRestController {

    private final PostsService blogService;

    public PostRestController(PostsService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogEditViewModel> createBlog(@RequestBody @Valid BlogCreateRequest createViewModel) {
        return ResponseEntity.ok(this.blogService.createBlog(createViewModel));
    }

    @GetMapping
    public ResponseEntity<Page<BlogCardViewModel>> getBlogs(Pageable pageable) {
        Page<BlogCardViewModel> blogs = this.blogService.getBlogs(pageable);
        return ResponseEntity.ok(blogs);
    }

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long blogId,
                                           @RequestBody @Valid BlogCommentCreateRequest commentCreateRequest,
                                           @AuthenticationPrincipal UserEntity currentUser) {
        this.blogService.addComment(blogId, commentCreateRequest, currentUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{blogId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long blogId,
                                              @PathVariable Long commentId,
                                              @AuthenticationPrincipal UserEntity currentUser) {
        this.blogService.deleteComment(blogId, commentId, currentUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{blogId}/likes")
    public ResponseEntity<Void> likeBlogPost(@PathVariable Long blogId, @AuthenticationPrincipal UserEntity userEntity) {
        this.blogService.likeBlogPost(blogId, userEntity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{blogId}/unlike")
    public ResponseEntity<Void> updateBlogLike(@PathVariable Long blogId, @AuthenticationPrincipal UserEntity userEntity) {
        this.blogService.unlikeBlogPost(blogId, userEntity);
        return ResponseEntity.ok().build();
    }


}
