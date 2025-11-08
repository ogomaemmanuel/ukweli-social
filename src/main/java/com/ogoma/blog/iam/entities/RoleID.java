package com.ogoma.blog.iam.entities;

import java.io.Serializable;
import java.util.UUID;

public record RoleID(UUID id) implements Serializable {
    public RoleID {
        if (id == null) throw new IllegalArgumentException("Role id is required");
    }
    public RoleID() {
        this(UUID.randomUUID());
    }
}
