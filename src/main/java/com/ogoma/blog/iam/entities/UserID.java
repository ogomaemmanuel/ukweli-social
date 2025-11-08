package com.ogoma.blog.iam.entities;

import java.io.Serializable;
import java.util.UUID;

public record UserID(UUID id) implements Serializable {
    public UserID {
        if (id == null) throw new IllegalArgumentException("User id is required");
    }
    public UserID() {
        this(UUID.randomUUID());
    }
}
