package com.ogoma.blog.content.repository;
import com.ogoma.blog.content.entities.BlogEntity;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends BaseRepository<BlogEntity>  {
}
