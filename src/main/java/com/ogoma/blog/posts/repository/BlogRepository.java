package com.ogoma.blog.posts.repository;

import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends BaseRepository<PostEntity> {

    @Query( value = " SELECT EXISTS(Select 1 blogs_comments WHERE blog_id = :postId AND comment_id = :commentId)",nativeQuery = true)
    boolean existsByBlogIdAndCommentId(Long postId, Long commentId);
}
