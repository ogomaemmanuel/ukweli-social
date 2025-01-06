package com.ogoma.blog.notifications;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class NotificationEntity extends BaseEntity {
    private String message;
    private boolean isRead;
}
