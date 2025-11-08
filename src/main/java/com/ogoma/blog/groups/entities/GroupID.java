package com.ogoma.blog.groups.entities;

import java.io.Serializable;
import java.util.UUID;

public record GroupID(UUID id) implements Serializable {
    public GroupID {
        if (id == null) throw new IllegalArgumentException("Group id is required");
    }
    public GroupID() {
        this(UUID.randomUUID());
    }
}
