package com.ogoma.blog.iam.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.blog.iam.entities.UserEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDetailsCardViewModel {
    public UserDetailsCardViewModel(UserEntity user) {
        this.userName = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = user.getCreatedAt();
    }

    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @JsonProperty("joinDate")
    private LocalDateTime createdAt;
    private UserProfileSummaryViewModel profileSummary;

}
