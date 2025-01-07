package com.ogoma.blog.groups.entities;

import java.util.Set;

public enum GroupRole {
    ADMIN(Set.of(GroupPermission.APPROVE_POST,
            GroupPermission.DELETE_POST,
            GroupPermission.APPROVE_MEMBERSHIP,
            GroupPermission.REMOVE_MEMBER,
            GroupPermission.ELEVATE_MEMBER)),
    MEMBER(Set.of(GroupPermission.CREATE_POST, GroupPermission.COMMENT_ON_POST));

    private GroupRole(Set<GroupPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<GroupPermission> getGroupPermissions() {
        return permissions;
    }

    private final Set<GroupPermission> permissions;
}
