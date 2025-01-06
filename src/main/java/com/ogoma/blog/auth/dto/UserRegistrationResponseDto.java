package com.ogoma.blog.auth.dto;

import com.ogoma.blog.iam.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter

public final class UserRegistrationResponseDto {
    private final String username;
    private Long id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UserRegistrationResponseDto(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.email = userEntity.getEmail();
        this.id = userEntity.getId();
        this.createdAt = userEntity.getCreatedAt();
        this.updatedAt = userEntity.getUpdatedAt();
    }


}
