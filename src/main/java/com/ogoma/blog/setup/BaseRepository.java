package com.ogoma.blog.setup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T>, QueryByExampleExecutor<T> {
}
