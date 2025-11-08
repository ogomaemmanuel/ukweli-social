package com.ogoma.blog.iam.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.blog.iam.entities.UserEntity;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class UserCardViewModel {
    public UserCardViewModel(UserEntity user) {
        this.id = user.getId().id();
        this.userName = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = user.getCreatedAt();
        this.profileSummary = new UserProfileSummaryViewModel(user.getProfileStats());
    }

    private final UUID id;
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    @JsonProperty("joinDate")
    private Instant createdAt;
    private final UserProfileSummaryViewModel profileSummary;
}
