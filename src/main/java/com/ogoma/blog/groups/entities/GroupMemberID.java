package com.ogoma.blog.groups.entities;


import java.io.Serializable;
import java.util.UUID;

public record GroupMemberID(UUID id) implements Serializable {
    public GroupMemberID {
        if (id == null) throw new IllegalArgumentException("Group member id is required");
    }

    public GroupMemberID() {
        this(UUID.randomUUID());
    }
}
