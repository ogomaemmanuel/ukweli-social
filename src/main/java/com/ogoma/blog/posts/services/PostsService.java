package com.ogoma.blog.posts.services;

import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.posts.entities.PostLikeEntity;
import com.ogoma.blog.posts.entities.PostCommentsEntity;
import com.ogoma.blog.posts.dto.BlogCommentCreateRequest;
import com.ogoma.blog.posts.dto.BlogCreateRequest;
import com.ogoma.blog.posts.repository.BlogRepository;
import com.ogoma.blog.posts.viewmodels.BlogCardViewModel;
import com.ogoma.blog.posts.viewmodels.BlogEditViewModel;
import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PostsService {
    private final EntityManager entityManager;
    private final BlogRepository blogRepository;

    public PostsService(EntityManager entityManager, BlogRepository blogRepository) {
        this.entityManager = entityManager;
        this.blogRepository = blogRepository;
    }

    public BlogEditViewModel createBlog(BlogCreateRequest blogCreateRequest) {
        PostEntity blog = new PostEntity();
        blog.setTitle(blogCreateRequest.getTitle());
        blog.setContent(blogCreateRequest.getContent());
        this.blogRepository.save(blog);
        return new BlogEditViewModel(blog);
    }


    @Transactional
    public void likeBlogPost(Long id, UserEntity currentUser) {
        PostLikeEntity blogLike = new PostLikeEntity();
        blogLike.setCreatedAt(LocalDateTime.now());
        blogLike.setUpdatedAt(LocalDateTime.now());
        blogLike.setLikedBy(currentUser);
        PostEntity blog = this.blogRepository.getReferenceById(id);
        blog.addLike(blogLike);
        this.blogRepository.save(blog);
    }


    @Transactional
    public void addComment(Long blogId, BlogCommentCreateRequest commentCreateRequest, UserEntity currentUser) {

        // TODO: Fetching by id then updating is an ant pattern, when updating non collection elements use getByRefenceId
        //  you may also reach the column limit in postgres, 1600
        // but use it only in situations, where you want to check entity properties before updating
        var blogEntity = this.blogRepository.getReferenceById(blogId);
        PostCommentsEntity comments = new PostCommentsEntity();
        comments.setParentId(commentCreateRequest.getParentId());
        comments.setComment(commentCreateRequest.getComment());
        //only the root uses the @CreateTimeStamp and @UpdateTimeStamp and @CreatedBy and @LastModifiedBy
        comments.setCreatedBy(currentUser);
        comments.setCreatedAt(LocalDateTime.now());
        blogEntity.addComment(comments);
        this.blogRepository.save(blogEntity);

    }

    @Transactional(readOnly = true)
    // read only  makes the entities not to be cached for dirty checking
    public Page<BlogCardViewModel> getBlogs(Pageable pageable) {
        return this.blogRepository.findAll(pageable).map(BlogCardViewModel::new);
    }


    @Transactional
    public void deleteComment(Long postId, Long commentId, UserEntity currentUser) {
        PostEntity post = this.blogRepository.findByBlogIdAndCommentId(postId, commentId);
        post.getComments().size();
        post.removeComment(post.getComments().getFirst());
        blogRepository.save(post);


    }

    public void unlikeBlogPost(Long blogId, UserEntity userEntity) {
    }
}
