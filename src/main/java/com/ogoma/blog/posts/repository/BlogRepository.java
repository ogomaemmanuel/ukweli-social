package com.ogoma.blog.posts.repository;

import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends BaseRepository<PostEntity> {

    @Query( value = "SELECT EXISTS(Select count(pc.id) from PostCommentsEntity pc WHERE pc.blog.id = :postId AND pc.id = :commentId)")
    boolean existsByBlogIdAndCommentId(Long postId, Long commentId);


    @Query(value = "SELECT pe from PostEntity pe left join fetch pe.comments pc where pe.id =:blogId and pc.id=:commentId")
   Optional<PostEntity> findByBlogIdAndCommentId(Long blogId, Long commentId);
}
