package com.ogoma.blog.iam.entities;

import com.ogoma.blog.config.SecurityConfig;
import com.ogoma.blog.content.entities.BlogEntity;
import com.ogoma.blog.content.entities.UserProfileStats;
import com.ogoma.blog.content.entities.FollowerEntity;
import com.ogoma.blog.notifications.NotificationEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
public class UserEntity extends BaseEntity implements UserDetails {
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String email;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String phoneNumber;
    @OneToOne
    @Getter
    private UserProfileStats profileStats;
    @ManyToMany
    @Getter
    public Set<RoleEntity> roles = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Getter
    Set<FollowerEntity> followers = new HashSet<>();
    @ManyToMany
    Set<NotificationEntity> notifications = new HashSet<>();

    @OneToMany
    Set<BlogEntity> blogsCreated = new HashSet<>();

    @ManyToMany
    Set<BlogEntity> likedBlogs = new HashSet<>();

//    Set<BlogEntity>


    public void addFollower(FollowerEntity follower) {
        UserEntity otherUser = follower.getFollower();
        otherUser.incrementFollowing();
        this.followers.add(follower);
        if (profileStats != null) {
            this.profileStats.incrementFollowerCount();
        }
    }

    public void addNotification(NotificationEntity notificationEntity) {
        this.notifications.add(notificationEntity);
        if (profileStats != null) {
            profileStats.incrementNoticationCount();
        }
    }

    public void markNotificationAsRead(NotificationEntity notificationEntity) {
        this.notifications.remove(notificationEntity);
        if (profileStats != null) {
            profileStats.decrementNoticationCount();
        }
    }

    private void incrementFollowing() {
        this.profileStats.incrementFollowing();
    }

    private void decrementFollowing() {
        this.profileStats.decrementFollowing();
    }

    public void removeFollower(FollowerEntity follower) {
        UserEntity otherUser = follower.getFollower();
        otherUser.decrementFollowing();
        this.followers.remove(follower);
        if (profileStats != null) {
            this.profileStats.decrementFollowerCount();
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @PrePersist
    public void prePersist() {
        this.password = SecurityConfig.passwordEncoder().encode(password);
    }
}
