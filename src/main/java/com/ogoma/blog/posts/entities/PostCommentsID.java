package com.ogoma.blog.posts.entities;

import java.io.Serializable;
import java.util.UUID;

public record PostCommentsID(UUID id) implements Serializable {

    public PostCommentsID {
        if (id == null) throw new IllegalArgumentException("Post Comment Id is required");
    }

    public PostCommentsID() {
        this(UUID.randomUUID());
    }
}
