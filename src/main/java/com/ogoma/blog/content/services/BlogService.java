package com.ogoma.blog.content.services;

import com.ogoma.blog.exceptions.RecordNotFoundException;
import com.ogoma.blog.content.entities.BlogCommentsEntity;
import com.ogoma.blog.content.entities.BlogEntity;
import com.ogoma.blog.content.dto.BlogCommentCreateRequest;
import com.ogoma.blog.content.dto.BlogCreateRequest;
import com.ogoma.blog.content.repository.BlogRepository;
import com.ogoma.blog.content.viewmodels.BlogCardViewModel;
import com.ogoma.blog.content.viewmodels.BlogEditViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogEditViewModel createBlog(BlogCreateRequest blogCreateRequest) {
        BlogEntity blog = new BlogEntity();
        blog.setTitle(blogCreateRequest.getTitle());
        blog.setContent(blogCreateRequest.getContent());
        this.blogRepository.save(blog);
        return new BlogEditViewModel(blog);
    }

    public void addComment(Long blogId, BlogCommentCreateRequest commentCreateRequest) {
        if (this.blogRepository.existsById(blogId)) {
            // TODO Fetching by id then updating is an ant pattern, you may also reach the column limit in postgres, 1600
            BlogEntity blogEntity = this.blogRepository.getReferenceById(blogId);
            BlogCommentsEntity comments = new BlogCommentsEntity();
            comments.setParentId(commentCreateRequest.getParentId());
            comments.setComment(commentCreateRequest.getComment());
            blogEntity.addComment(comments);
            this.blogRepository.save(blogEntity);
            return;
        }
        throw new RecordNotFoundException("No blog exist with id" + blogId);
    }

    public Page<BlogCardViewModel> getBlogs(Pageable pageable) {
        return this.blogRepository.findAll(pageable).map(BlogCardViewModel::new);
    }
}
