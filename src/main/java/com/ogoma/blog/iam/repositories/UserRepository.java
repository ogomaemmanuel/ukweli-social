package com.ogoma.blog.iam.repositories;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
}
