package com.ogoma.blog.auth.dto;

import com.ogoma.blog.iam.entities.UserEntity;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter

public final class UserRegistrationResponseDto {
    private final String username;
    private final UUID id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final Instant createdAt;
    private final Instant updatedAt;

    public UserRegistrationResponseDto(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.email = userEntity.getEmail();
        this.id = userEntity.getId().id();
        this.createdAt = userEntity.getCreatedAt();
        this.updatedAt = userEntity.getUpdatedAt();
    }


}
