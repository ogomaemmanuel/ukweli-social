package com.ogoma.blog.posts.entities;

import java.io.Serializable;
import java.util.UUID;

public record PostLikeID(UUID id) implements Serializable {
    public PostLikeID {
        if(id==null) throw  new IllegalArgumentException("Post like id ir required");
    }
    public PostLikeID(){
        this(UUID.randomUUID());
    }
}
