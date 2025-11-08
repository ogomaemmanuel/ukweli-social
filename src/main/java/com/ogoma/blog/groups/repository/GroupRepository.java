package com.ogoma.blog.groups.repository;

import com.ogoma.blog.groups.entities.GroupEntity;
import com.ogoma.blog.groups.entities.GroupID;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, GroupID>, JpaSpecificationExecutor<GroupEntity> {
}
