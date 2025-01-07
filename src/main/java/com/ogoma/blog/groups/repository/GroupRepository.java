package com.ogoma.blog.groups.repository;

import com.ogoma.blog.groups.entities.GroupEntity;
import com.ogoma.blog.setup.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface GroupRepository extends BaseRepository<GroupEntity> {
}
