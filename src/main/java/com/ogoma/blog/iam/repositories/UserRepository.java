package com.ogoma.blog.iam.repositories;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.entities.UserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UserID> , JpaSpecificationExecutor<UserEntity> {
}
