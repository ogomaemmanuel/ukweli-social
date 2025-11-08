package com.ogoma.blog.notifications;

import java.io.Serializable;
import java.util.UUID;

public record NotificationID(UUID id) implements Serializable {
    public NotificationID {
        if (id == null) throw new IllegalArgumentException("Notification id is required");
    }

    public NotificationID() {
        this(UUID.randomUUID());
    }
}
