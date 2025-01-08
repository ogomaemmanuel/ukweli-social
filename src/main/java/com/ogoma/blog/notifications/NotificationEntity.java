package com.ogoma.blog.notifications;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "notifications")
public class NotificationEntity extends BaseEntity {
    private String message;
    private boolean isRead;
}
