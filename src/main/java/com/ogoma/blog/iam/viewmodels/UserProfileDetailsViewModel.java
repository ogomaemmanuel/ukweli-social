package com.ogoma.blog.iam.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.blog.iam.entities.UserEntity;
import lombok.Getter;

import java.time.Instant;
@Getter
public class UserProfileDetailsViewModel {

    public UserProfileDetailsViewModel(UserEntity user) {
        if (user != null) {
            this.userName = user.getUsername();
            this.phoneNumber = user.getPhoneNumber();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.createdAt = user.getCreatedAt();
            this.profileSummary = new UserProfileSummaryViewModel(user.getProfileStats());
        }
    }

    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @JsonProperty("joinDate")
    private Instant createdAt;
    private UserProfileSummaryViewModel profileSummary;
}
