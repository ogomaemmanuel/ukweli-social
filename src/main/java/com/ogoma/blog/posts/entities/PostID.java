package com.ogoma.blog.posts.entities;

import java.io.Serializable;
import java.util.UUID;

public record PostID(UUID id) implements Serializable {

    public PostID {
        if (id == null) throw new IllegalArgumentException("Post id is required");
    }

    public PostID() {
        this(UUID.randomUUID());
    }

}
