package com.ogoma.blog.setup;

import com.ogoma.blog.iam.entities.UserID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
//@SoftDelete
@EntityListeners(AuditingEntityListener.class)
//@DynamicUpdate
public class BaseEntity implements Serializable {

    @Version
    protected Long version;
    protected Instant createdAt;
    protected Instant updatedAt;
    @CreatedBy
    @AttributeOverride(name = "id",
            column = @Column(name = "created_by"))
    @Embedded
    protected UserID createdBy;
    @LastModifiedBy
    @AttributeOverride(name = "id",
            column = @Column(name = "last_modified_by"))
    @Embedded
    protected UserID lastModifiedBy;

    protected BaseEntity() {
        var now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
}
