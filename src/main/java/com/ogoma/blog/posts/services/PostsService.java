package com.ogoma.blog.posts.services;

import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.posts.dto.BlogCommentCreateRequest;
import com.ogoma.blog.posts.dto.BlogCreateRequest;
import com.ogoma.blog.posts.entities.PostCommentsID;
import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.posts.entities.PostID;
import com.ogoma.blog.posts.repository.BlogRepository;
import com.ogoma.blog.posts.viewmodels.BlogCardViewModel;
import com.ogoma.blog.posts.viewmodels.BlogEditViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PostsService {
    private final BlogRepository blogRepository;

    public PostsService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogEditViewModel createBlog(BlogCreateRequest blogCreateRequest) {
        PostEntity blog = PostEntity.createNewPost(
                blogCreateRequest.getTitle(),
                blogCreateRequest.getContent(),
                blogCreateRequest.getVisibility(),
                blogCreateRequest.getMediaUrls(),true);
        this.blogRepository.save(blog);
        log.info("Blog {} saved successfully",blog.getId());
        return new BlogEditViewModel(blog);
    }


    @Transactional
    public void likeBlogPost(PostID id, UserEntity currentUser) {
        PostEntity blog = this.blogRepository.getReferenceById(id);
        blog.addLike(currentUser);
        this.blogRepository.save(blog);
    }


    @Transactional
    public void addComment(PostID postID, BlogCommentCreateRequest commentCreateRequest, UserEntity currentUser) {
        // TODO: Fetching by id then updating is an ant pattern, when updating non collection elements use getByRefenceId
        //  you may also reach the column limit in postgres, 1600
        // but use it only in situations, where you want to check entity properties before updating
        var blogEntity = this.blogRepository.getReferenceById(postID);
        //only the root uses the @CreateTimeStamp and @UpdateTimeStamp and @CreatedBy and @LastModifiedBy
        blogEntity.addComment(
                commentCreateRequest.getComment(),
                commentCreateRequest.getParentId(),
                currentUser.getId()
                );
        this.blogRepository.save(blogEntity);
    }

    @Transactional(readOnly = true)
    // read only  makes the entities not to be cached for dirty checking
    public Page<BlogCardViewModel> getBlogs(Pageable pageable) {
        return this.blogRepository.findAll(pageable)
                .map(BlogCardViewModel::new);
    }


    @Transactional
    public void deleteComment(PostID postId, Long commentId, UserEntity currentUser) {
        this.blogRepository.findByBlogIdAndCommentId(postId, commentId)
                .ifPresentOrElse(postEntity -> {
                    postEntity.removeComment(postEntity.getComments().getFirst());
                    blogRepository.save(postEntity);
                }, () -> {
                    throw new RecordNotFoundException("No comment found");
                });

    }

    public void unlikeBlogPost(PostID blogId, UserEntity userEntity) {
    }
}
