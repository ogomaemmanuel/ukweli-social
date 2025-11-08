package com.ogoma.blog.notifications;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "notifications")
public class NotificationEntity extends BaseEntity {
    @EmbeddedId
    private NotificationID id;
    private String message;
    private boolean isRead;

    protected NotificationEntity() {
        super();
        id = new NotificationID();
    }
}
