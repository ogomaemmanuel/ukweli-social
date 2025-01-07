package com.ogoma.blog.groups.entities;

import com.ogoma.blog.content.entities.BlogEntity;
import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class GroupPostEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @ManyToOne
    private GroupEntity group;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private UserEntity postedBy;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private BlogEntity blog;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
