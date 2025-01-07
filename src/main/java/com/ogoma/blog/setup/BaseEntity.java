package com.ogoma.blog.setup;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SoftDelete
@EntityListeners(AuditingEntityListener.class)
//@DynamicUpdate
public class BaseEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private Long version;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @CreatedBy
    private UserEntity createdBy;

    @LastModifiedBy
    @ManyToOne
    public UserEntity lastModifiedBy;
    @NaturalId
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String systemGeneratedId;


}
